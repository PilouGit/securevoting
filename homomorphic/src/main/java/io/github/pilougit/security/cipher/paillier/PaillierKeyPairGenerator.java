package io.github.pilougit.security.cipher.paillier;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;

public class PaillierKeyPairGenerator extends KeyPairGeneratorSpi {
    private SecureRandom secureRandom=new SecureRandom();

    private int keysize=2048;
    @Override
    public void initialize(int keysize, SecureRandom random) {
        this.secureRandom=random;
        this.keysize=keysize;
    }
    private BigInteger ppcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }
    @Override
    public KeyPair generateKeyPair() {
        BigInteger p = BigInteger.probablePrime(keysize / 2, secureRandom);
        BigInteger q = BigInteger.probablePrime(keysize / 2, secureRandom);
        BigInteger n = p.multiply(q);
        BigInteger lambda = ppcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        BigInteger nsquare = n.multiply(n); // nsquare = n*n
        BigInteger g;
        do {
            // generate g, a random integer in Z*_{n^2}
            do {
                g = new BigInteger(keysize, 64, secureRandom);
            } while (g.compareTo(nsquare) >= 0
                    || g.gcd(nsquare).intValue() != 1);

            // verify g, the following must hold: gcd(L(g^lambda mod n^2), n) =
            // 1,
            // where L(u) = (u-1)/n
        } while (g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n)
                .gcd(n).intValue() != 1);

        // mu = (L(g^lambda mod n^2))^{-1} mod n, where L(u) = (u-1)/n
        BigInteger mu = g.modPow(lambda, nsquare).subtract(BigInteger.ONE)
                .divide(n).modInverse(n);
        PaillierPublicKey publicKey = new PaillierPublicKey(n, g, nsquare);
        PaillierPrivateKey privateKey = new PaillierPrivateKey(lambda, mu,
                nsquare, n);

        return new KeyPair(publicKey, privateKey);
    }
}
