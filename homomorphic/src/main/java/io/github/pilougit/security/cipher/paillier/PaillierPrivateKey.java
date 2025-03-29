package io.github.pilougit.security.cipher.paillier;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;

public class PaillierPrivateKey implements PrivateKey {
    public PaillierPrivateKey(BigInteger lambda, BigInteger mu, BigInteger nsquare, BigInteger n) {
    }

    @Override
    public String getAlgorithm() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }
}
