package net.sourceforge.cardme.vcard.features;

import java.util.Calendar;
import java.util.Date;

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
 * Aug 9, 2012
 * 
 * <p><b>RFC 2426</b><br/>
 * <b>3.6.4 REV Type Definition</b>
 * <ul>
 * 	<li><b>Type name:</b> REV</li>
 * 	<li><b>Type purpose:</b> To specify revision information about the current vCard.</li>
 * 	<li><b>Type encoding:</b> 8bit</li>
 * 	<li><b>Type value:</b> The default is a single date-time value. Can also be reset to a single date value.</li>
 * 	<li><b>Type special note:</b> The value distinguishes the current revision of the information in this vCard for other renditions of the information.</li>
 * </ul>
 * </p>
 */
public interface RevFeature {
	
	/**
	 * <p>Retrieves the revision date as a {@link Calendar} object.</p>
	 * 
	 * @return the revision date or null if not set
	 */
	public Calendar getRevision();
	
	/**
	 * <p>Set the revision date as a {@link Calendar} object.</p>
	 * 
	 * @param calendar - the revision date to set
	 */
	public void setRevision(Calendar calendar);
	
	/**
	 * <p>Set the revision date as a {@link Date} object.</p>
	 * 
	 * @param date - the revision date to set
	 */
	public void setRevision(Date date);
	
	/**
	 * <p>Removes the revision date.</p>
	 */
	public void clearRevision();
	
	/**
	 * <p>Indicates if the revision date has been set.</p>
	 * 
	 * @return true if the revision date has been set or false otherwise
	 */
	public boolean hasRevision();
}
