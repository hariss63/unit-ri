/*
 * Units of Measurement Reference Implementation
 * Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tec.units.ri.internal.format.l10n;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class AttributedStringTest {

    private static final Attribute[] internalAttributes() {
	Attribute[] atts = new Attribute[4];
	for (int i = 0; i < 4; i++) {
	    atts[i] = new Attribute(String.valueOf(i));
	}
	return atts;
    }

    static AttributedString sut;

    @BeforeClass
    public static void init() {
	sut = new AttributedString("test");
    }

    @Test
    public void testGetIterator() {
	assertNotNull(sut.getIterator());
    }

    @Test
    public void testText() {
	assertEquals("test", sut.text);
    }

    @Test(expected = NullPointerException.class)
    public void testAttributedStringNull() {
	final String ns = null;
	AttributedString as = new AttributedString(ns);
    }

    @Test(expected = NullPointerException.class)
    public void testAttributedStringNullIteratorArr() {
	final AttributedCharacterIterator[] ns = null;
	AttributedString as = new AttributedString(ns);
    }

    @Test
    public void testAttributedStringIterator() {
	final AttributedCharacterIterator it = sut.getIterator(
		internalAttributes(), 0, 4);
	AttributedString as = new AttributedString(it, 0, 4);
    }

    /*
     * @Test public void testAttributedStringStringMap() { fail(
     * "Not yet implemented"); }
     * 
     * @Test public void testAttributedStringAttributedCharacterIterator() {
     * fail("Not yet implemented"); }
     * 
     * @Test public void testAttributedStringAttributedCharacterIteratorIntInt()
     * { fail("Not yet implemented"); }
     * 
     * @Test public void
     * testAttributedStringAttributedCharacterIteratorIntIntAttributeArray() {
     * fail("Not yet implemented"); }
     * 
     * @Test public void testAddAttributeAttributeObject() { fail(
     * "Not yet implemented"); }
     * 
     * @Test public void testAddAttributeAttributeObjectIntInt() { fail(
     * "Not yet implemented"); }
     * 
     * @Test public void testAddAttributes() { sut.a }
     * 
     * @Test public void testGetIteratorAttributeArray() { fail(
     * "Not yet implemented"); }
     * 
     * @Test public void testGetIteratorAttributeArrayIntInt() { fail(
     * "Not yet implemented"); }
     */
    @Test
    public void testLength() {
	assertEquals(4, sut.length());
    }

}
