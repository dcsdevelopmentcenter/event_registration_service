package com.dcs.user.registration.config.security;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.exceptions.EventPlanningRuntimeException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class EventPlannerEncryptionUtil
{
	private final static Logger LOGGER = LoggerFactory.getLogger(EventPlannerEncryptionUtil.class);
	private final String key = "1234567812345678";
	private final String initVector = "1234567812345678";
	private final String algo = "AES/CBC/PKCS5PADDING";

	public String encrypt(final String value){
		try{
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),"AES");

			Cipher cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE,keySpec,iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException |
				 BadPaddingException e)
		{
			LOGGER.error(e.getMessage(),e);
			throw new EventPlanningRuntimeException(e);

		}
	}
}
