package org.testingzone.dbo.base;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.GregorianCalendar;
import java.util.UUID;

@SuppressWarnings("UnusedDeclaration")
public class IdGenerator implements IdentifierGenerator {

    private static final GregorianCalendar mpEpoch = new GregorianCalendar(2013, 1, 1, 0, 0, 0);
    private static byte[] workerID = null;
    private static int counter = 0;
    private static long lastGenInMs;

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return BinaryKey.valueOf(generateUUIDAsBytes());
    }

    public static String toUUID(byte[] id) {
        assert id.length == 16;
        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (id[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (id[i] & 0xff);
        }
        return new UUID(msb, lsb).toString();
    }

    public static String generateUUIDAsString() {
        return toUUID(generateUUIDAsBytes());
    }

    private static byte[] generateUUIDAsBytes() {
        byte[] key = new byte[16];
        update();
        // set the counter as our first 2 bytes
        byte[] lastTimeGen = fromLong(lastGenInMs);
        System.arraycopy(lastTimeGen, 0, key, 0, 8);

        key[8] = (byte) counter;
        key[9] = (byte) (counter >> 8);
        // next 6 are the worker id (Will by the server Mac addres or the Thread
        // id that started the UUIDgenerator
        int j = 0; // used for workID offset
        if (workerID == null || workerID.length <= 1) {
            workerID = getAlternativeWorkerId();
        }
        if (workerID.length > 6) {
            j = workerID.length - 6;
        }
        for (int i = 0; i < 6; i++, j++) {
            key[i + 10] = workerID[j];
        }

        return key;
    }

    private static synchronized void update() {
        long timeInMs = currentTime();
        if (lastGenInMs > timeInMs) {
            throw new RuntimeException("Clock is running backwards");
        }
        counter = (lastGenInMs < timeInMs) ? 0 : counter + 1;
        lastGenInMs = timeInMs;
    }

    private static byte[] fromLong(long value) {
        return ByteBuffer.allocate(8).putLong(value).array();
    }

    private static byte[] getAlternativeWorkerId() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);

            // This fix is Linux specific
            if (ni == null) {
                return getThreadId();
            }
            byte[] mac = ni.getHardwareAddress();
            if (mac == null || mac.length < 6) {
                mac = getThreadId();
            }
            return mac;
        } catch (Exception e) {
            return getThreadId();
        }
    }

    private static byte[] getThreadId() {
        long threadId = Thread.currentThread().getId();
        return fromLong(threadId);
    }

    private static long currentTime() {
        return System.currentTimeMillis() - mpEpoch.getTimeInMillis();
    }
}
