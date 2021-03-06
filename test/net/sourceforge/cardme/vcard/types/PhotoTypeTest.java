package net.sourceforge.cardme.vcard.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import net.sourceforge.cardme.vcard.arch.EncodingType;
import net.sourceforge.cardme.vcard.arch.VCardTypeName;
import net.sourceforge.cardme.vcard.types.media.ImageMediaType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Copyright 2012 George El-Haddad. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 * 
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY GEORGE EL-HADDAD ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GEORGE EL-HADDAD OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of George El-Haddad.
 */

/**
 * 
 * @author George El-Haddad
 * <br/>
 * Aug 27, 2012
 *
 */
public class PhotoTypeTest {

	private PhotoType photoTypeBin = null;
	private PhotoType photoTypeUri = null;
	
	@Before
	public void setUp() throws Exception {
		photoTypeBin = new PhotoType();
		photoTypeBin.setPhoto(new byte[] {0x01, 0x02, 0x03, 0x04, 0x05});
		photoTypeBin.setEncodingType(EncodingType.BINARY);
		photoTypeBin.setCompression(false);
		photoTypeBin.setImageMediaType(ImageMediaType.JPEG);
		
		photoTypeUri = new PhotoType();
		photoTypeUri.setPhotoURI(new URI("file://C:/my_photos/john.jpg"));
		photoTypeUri.setEncodingType(EncodingType.EIGHT_BIT);
	}
	
	@After
	public void tearDown() throws Exception {
		photoTypeBin = null;
		photoTypeUri = null;
	}
	
	@Test
	public void testGetPhoto() throws URISyntaxException {
		byte[] photoBytes = photoTypeBin.getPhoto();
		assertTrue(Arrays.equals(new byte[] {0x01, 0x02, 0x03, 0x04, 0x05}, photoBytes));
		
		URI photoUri = photoTypeUri.getPhotoURI();
		assertEquals(new URI("file://C:/my_photos/john.jpg"), photoUri);
	}
	
	@Test
	public void testIsCompressed() {
		assertFalse(photoTypeBin.isCompressed());
		assertFalse(photoTypeUri.isCompressed());
	}
	
	@Test
	public void testGetPhotoEncodingType() {
		assertEquals(EncodingType.BINARY, photoTypeBin.getEncodingType());
		assertEquals(EncodingType.EIGHT_BIT, photoTypeUri.getEncodingType());
	}
	
	@Test
	public void testIsBinary() {
		assertTrue(photoTypeBin.isBinary());
		assertFalse(photoTypeUri.isBinary());
	}
	
	@Test
	public void testGetTypeString() {
		assertEquals(VCardTypeName.PHOTO.getType(), photoTypeBin.getVCardTypeName().getType());
	}
	
	@Test
	public void testEquals() throws URISyntaxException {
		PhotoType PhotoTypeBin2 = new PhotoType();
		PhotoTypeBin2.setPhoto(new byte[] {0x01, 0x02, 0x03, 0x04, 0x05});
		PhotoTypeBin2.setEncodingType(EncodingType.BINARY);
		PhotoTypeBin2.setCompression(false);
		PhotoTypeBin2.setImageMediaType(ImageMediaType.JPEG);
		
		PhotoType PhotoTypeUri2 = new PhotoType();
		PhotoTypeUri2.setPhotoURI(new URI("file://C:/my_photos/john.jpg"));
		PhotoTypeUri2.setEncodingType(EncodingType.EIGHT_BIT);
		
		assertTrue(photoTypeBin.equals(PhotoTypeBin2));
		assertTrue(photoTypeUri.equals(PhotoTypeUri2));
	}
	
	@Test
	public void testHashcode() throws URISyntaxException {
		PhotoType PhotoTypeBin2 = new PhotoType();
		PhotoTypeBin2.setPhoto(new byte[] {0x01, 0x02, 0x03, 0x04, 0x05});
		PhotoTypeBin2.setEncodingType(EncodingType.BINARY);
		PhotoTypeBin2.setCompression(false);
		PhotoTypeBin2.setImageMediaType(ImageMediaType.JPEG);
		
		PhotoType PhotoTypeUri2 = new PhotoType();
		PhotoTypeUri2.setPhotoURI(new URI("file://C:/my_photos/john.jpg"));
		PhotoTypeUri2.setEncodingType(EncodingType.EIGHT_BIT);
		
		int hcode1 = photoTypeBin.hashCode();
		int hcode2 = PhotoTypeBin2.hashCode();
		assertEquals(hcode1, hcode2);
		
		hcode1 = photoTypeUri.hashCode();
		hcode2 = PhotoTypeUri2.hashCode();
		assertEquals(hcode1, hcode2);
	}
	
	@Test
	public void testCompareTo() throws URISyntaxException {
		PhotoType PhotoTypeBin2 = new PhotoType();
		PhotoTypeBin2.setPhoto(new byte[] {0x01, 0x02, 0x03, 0x04, 0x05});
		PhotoTypeBin2.setEncodingType(EncodingType.BINARY);
		PhotoTypeBin2.setCompression(false);
		PhotoTypeBin2.setImageMediaType(ImageMediaType.JPEG);
		
		PhotoType PhotoTypeUri2 = new PhotoType();
		PhotoTypeUri2.setPhotoURI(new URI("file://C:/my_photos/john.jpg"));
		PhotoTypeUri2.setEncodingType(EncodingType.EIGHT_BIT);
		
		assertTrue(photoTypeBin.compareTo(PhotoTypeBin2) == 0);
		assertTrue(photoTypeUri.compareTo(PhotoTypeUri2) == 0);
	}
	
	@Test
	public void testClone() {
		PhotoType cloned1 = photoTypeBin.clone(); 
		PhotoType cloned2 = photoTypeUri.clone(); 
		
		assertEquals(photoTypeBin, cloned1);
		assertTrue(photoTypeBin.equals(cloned1));
		
		assertEquals(photoTypeUri, cloned2);
		assertTrue(photoTypeUri.equals(cloned2));
		
		assertTrue(photoTypeBin.compareTo(cloned1) == 0);
		assertTrue(photoTypeUri.compareTo(cloned2) == 0);
	}
}
