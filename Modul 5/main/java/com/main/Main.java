package com.main;

import java.security.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            Scanner scanner = new Scanner(System.in);
            System.out.println("AWAS PROGRAM INI MENGANDUNG ZAT BERBAHAYA ");
            System.out.print("Masukkan kode morse bang: ");
            String message = scanner.nextLine();

            if (message.equals("231204")) {
                Signature rsa = Signature.getInstance("SHA256withRSA");
                rsa.initSign(privateKey);
                rsa.update(message.getBytes());
                byte[] signature = rsa.sign();

                rsa.initVerify(publicKey);
                rsa.update(message.getBytes());
                boolean verifies = rsa.verify(signature);

                if (verifies) {
                    LibrarySystem app = new LibrarySystem();
                    app.menu();
                } else {
                    System.out.println("Verifikasi Gagal.");
                }
            } else {
                System.out.println("Pesan tidak valid, coba lagi.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }
