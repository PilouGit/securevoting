package io.github.pilougit.security.cipher.paillier;

import java.security.Provider;

public class PaillierProvider extends Provider {
    protected PaillierProvider() {
        super("Paillier", 1.0, "Paillier's Cryptography Provider");
        /**
         * Key Pair Generator engine
         */
        put("KeyPairGenerator.Paillier",
                "io.github.pilougit.security.cipher.paillier.PaillierKeyPairGenerator");
    }
}
