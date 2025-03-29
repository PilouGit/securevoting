package io.github.pilougit.security.cipher.paillier;

import java.math.BigInteger;
import java.security.PublicKey;

public class PaillierPublicKey implements PublicKey {
    public PaillierPublicKey(BigInteger n, BigInteger g, BigInteger nsquare) {
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
