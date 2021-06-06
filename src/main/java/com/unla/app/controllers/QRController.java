package com.unla.app.controllers;

import java.util.Base64;

import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.QRHelper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRController {

	@GetMapping(value = "/api/qr/{codeText}/{width}/{height}")
	public ResponseEntity<String> generateQRCode(@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width, @PathVariable("height") Integer height) throws Exception {
		String url = ConfigHelper.appUrl + "permisos/" + codeText;
		String encodedFile = Base64.getEncoder().encodeToString(QRHelper.getQRCodeImage(url, width, height));
		return ResponseEntity.status(HttpStatus.OK).body(encodedFile);
	}
}
