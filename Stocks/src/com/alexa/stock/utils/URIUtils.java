package com.alexa.stock.utils;


/*
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
 
 
import java.util.BitSet;
 
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.http.util.EncodingUtils;
 
/**
 * The URI escape and character encoding and decoding utility.
 * It's compatible with {@link org.apache.commons.httpclient.HttpURL} rather
 * than {@link org.apache.commons.httpclient.URI}.
 *
 * @author <a href="mailto:jericho@apache.org">Sung-Gu</a>
 * @version $Revision: 507321 $ $Date: 2002/03/14 15:14:01 
 */
public class URIUtils {
 
    // ----------------------------------------------------- Instance variables
 
    protected static final BitSet empty = new BitSet(1);
 
    // ---------------------------------------------------------- URI utilities
 
    /**
     * Get the basename of an URI.   It's possibly an empty string.
     *
     * @param uri a string regarded an URI
     * @return the basename string; an empty string if the path ends with slash
     */
    public static String getName(String uri) {
        if (uri == null || uri.length() == 0) { return uri; } 
        String path = getPath(uri);
        int at = path.lastIndexOf("/");
        int to = path.length();
        return (at >= 0) ? path.substring(at + 1, to) : path;
    }
 
 
    /**
     * Get the query of an URI.
     *
     * @param uri a string regarded an URI
     * @return the query string; <code>null</code> if empty or undefined
     */
    public static String getQuery(String uri) {
        if (uri == null || uri.length() == 0) { return null; } 
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
            "/", 
            at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored
        int to = uri.length();
        // reuse the at and from variables to consider the query
        at = uri.indexOf("?", from);
        if (at >= 0) {
            from = at + 1;
        } else {
            return null;
        }
        // check the fragment
        if (uri.lastIndexOf("#") > from) {
            to = uri.lastIndexOf("#");
        }
        // get the path and query.
        return (from < 0 || from == to) ? null : uri.substring(from, to);
    }
 
 
    /**
     * Get the path of an URI.
     *
     * @param uri a string regarded an URI
     * @return the path string
     */
    public static String getPath(String uri) {
        if (uri == null) {
            return null;
        } 
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
            "/", 
            at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored 
        int to = uri.length();
        // check the query
        if (uri.indexOf('?', from) != -1) {
            to = uri.indexOf('?', from);
        }
        // check the fragment
        if (uri.lastIndexOf("#") > from && uri.lastIndexOf("#") < to) {
            to = uri.lastIndexOf("#");
        }
        // get only the path.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from, to);
    }
 
 
    /**
     * Get the path and query of an URI.
     *
     * @param uri a string regarded an URI
     * @return the path and query string
     */
    public static String getPathQuery(String uri) {
        if (uri == null) {
            return null;
        } 
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
            "/", 
            at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored
        int to = uri.length();
        // Ignore the '?' mark so to ignore the query.
        // check the fragment
        if (uri.lastIndexOf("#") > from) {
            to = uri.lastIndexOf("#");
        }
        // get the path and query.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from, to);
    }
 
 
    /**
     * Get the path of an URI and its rest part.
     *
     * @param uri a string regarded an URI
     * @return the string from the path part
     */
    public static String getFromPath(String uri) {
        if (uri == null) {
            return null;
        } 
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
            "/", 
            at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // get the path and its rest.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from);
    }
 
    // ----------------------------------------------------- Encoding utilities
 
    /**
     * Get the all escaped and encoded string with the default protocl charset.
     * It's the same function to use <code>encode(String unescaped, Bitset
     * empty, "UTF-8")</code>.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     *
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodeAll(String unescaped) throws URIException {
        return encodeAll(unescaped, "UTF-8");
    }
 
 
    /**
     * Get the all escaped and encoded string with a given charset.
     * It's the same function to use <code>encode(String unescaped, Bitset
     * empty, String charset)</code>.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodeAll(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, empty, charset);
    }
  
 
    /**
     * Escape and encode a string regarded as within the authority component of
     * an URI with the default protocol charset.
     * Within the authority component, the characters ";", ":", "@", "?", and
     * "/" are reserved.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodeWithinAuthority(String unescaped)
        throws URIException {
 
        return encodeWithinAuthority(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as within the authority component of
     * an URI with a given charset.
     * Within the authority component, the characters ";", ":", "@", "?", and
     * "/" are reserved.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodeWithinAuthority(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, allowed_within_authority, charset);
    }
 
 
    /**
     * Escape and encode a string regarded as the path and query components of
     * an URI with the default protocol charset.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodePathQuery(String unescaped) throws URIException {
        return encodePathQuery(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as the path and query components of
     * an URI with a given charset.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodePathQuery(String unescaped, String charset)
        throws URIException {
 
        int at = unescaped.indexOf('?');
        if (at < 0) {
            return encode(unescaped, allowed_abs_path, charset);
        }
        // else
        return  encode(unescaped.substring(0, at), allowed_abs_path, charset)
            + '?' + encode(unescaped.substring(at + 1), allowed_query, charset);
    }
 
 
    /**
     * Escape and encode a string regarded as within the path component of an
     * URI with the default protocol charset.
     * The path may consist of a sequence of path segments separated by a
     * single slash "/" character.  Within a path segment, the characters
     * "/", ";", "=", and "?" are reserved.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodeWithinPath(String unescaped)
        throws URIException {
 
        return encodeWithinPath(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as within the path component of an
     * URI with a given charset.
     * The path may consist of a sequence of path segments separated by a
     * single slash "/" character.  Within a path segment, the characters
     * "/", ";", "=", and "?" are reserved.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodeWithinPath(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, allowed_within_path, charset);
    }
 
 
    /**
     * Escape and encode a string regarded as the path component of an URI with
     * the default protocol charset.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodePath(String unescaped) throws URIException {
        return encodePath(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as the path component of an URI with
     * a given charset.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodePath(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, allowed_abs_path, charset);
    }
 
 
    /**
     * Escape and encode a string regarded as within the query component of an
     * URI with the default protocol charset.
     * When a query comprise the name and value pairs, it is used in order
     * to encode each name and value string.  The reserved special characters
     * within a query component are being included in encoding the query.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodeWithinQuery(String unescaped)
        throws URIException {
 
        return encodeWithinQuery(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as within the query component of an
     * URI with a given charset.
     * When a query comprise the name and value pairs, it is used in order
     * to encode each name and value string.  The reserved special characters
     * within a query component are being included in encoding the query.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodeWithinQuery(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, allowed_within_query, charset);
    }
 
 
    /**
     * Escape and encode a string regarded as the query component of an URI with
     * the default protocol charset.
     * When a query string is not misunderstood the reserved special characters
     * ("&amp;", "=", "+", ",", and "$") within a query component, this method
     * is recommended to use in encoding the whole query.
     *
     * @param unescaped an unescaped string
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     * @see #encode
     */
    public static String encodeQuery(String unescaped) throws URIException {
        return encodeQuery(unescaped, "UTF-8");
    }
 
 
    /**
     * Escape and encode a string regarded as the query component of an URI with
     * a given charset.
     * When a query string is not misunderstood the reserved special characters
     * ("&amp;", "=", "+", ",", and "$") within a query component, this method
     * is recommended to use in encoding the whole query.
     *
     * @param unescaped an unescaped string
     * @param charset the charset
     * @return the escaped string
     * 
     * @throws URIException if the charset is not supported
     * 
     * @see #encode
     */
    public static String encodeQuery(String unescaped, String charset)
        throws URIException {
 
        return encode(unescaped, allowed_query, charset);
    }
 
 
    /**
     * Escape and encode a given string with allowed characters not to be
     * escaped and the default protocol charset.
     *
     * @param unescaped a string
     * @param allowed allowed characters not to be escaped
     * @return the escaped string
     * 
     * @throws URIException if the default protocol charset is not supported
     * 
     * @see URI#getDefaultProtocolCharset
     */
    public static String encode(String unescaped, BitSet allowed)
        throws URIException {
 
        return encode(unescaped, allowed, "UTF-8");
    }
 
 
    /**
     * Escape and encode a given string with allowed characters not to be
     * escaped and a given charset.
     *
     * @param unescaped a string
     * @param allowed allowed characters not to be escaped
     * @param charset the charset
     * @return the escaped string
     */
    public static String encode(String unescaped, BitSet allowed,
            String charset) throws URIException {
        byte[] rawdata = URLCodec.encodeUrl(allowed, 
            EncodingUtils.getBytes(unescaped, charset));
        return EncodingUtils.getAsciiString(rawdata);
    }
 
 
    /**
     * Unescape and decode a given string regarded as an escaped string with the
     * default protocol charset.
     *
     * @param escaped a string
     * @return the unescaped string
     * 
     * @throws URIException if the string cannot be decoded (invalid)
     * 
     * @see URI#getDefaultProtocolCharset
     */
    public static String decode(String escaped) throws URIException {
        try {
            byte[] rawdata = URLCodec.decodeUrl(EncodingUtils.getAsciiBytes(escaped));
            return EncodingUtils.getString(rawdata, "UTF-8");
        } catch (DecoderException e) {
            throw new URIException(e.getMessage());
        }
    }
 
    
    /**
     * The percent "%" character always has the reserved purpose of being the
     * escape indicator, it must be escaped as "%25" in order to be used as
     * data within a 
     */
    protected static final BitSet percent = new BitSet(256);
    // Static initializer for percent
    static {
        percent.set('%');
    }
 
 
    /**
     * BitSet for digit.
     * <p><blockquote><pre>
     * digit    = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" |
     *            "8" | "9"
     * </pre></blockquote><p>
     */
    protected static final BitSet digit = new BitSet(256);
    // Static initializer for digit
    static {
        for (int i = '0'; i <= '9'; i++) {
            digit.set(i);
        }
    }
 
 
    /**
     * BitSet for alpha.
     * <p><blockquote><pre>
     * alpha         = lowalpha | upalpha
     * </pre></blockquote><p>
     */
    protected static final BitSet alpha = new BitSet(256);
    // Static initializer for alpha
    static {
        for (int i = 'a'; i <= 'z'; i++) {
            alpha.set(i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            alpha.set(i);
        }
    }
 
 
    /**
     * BitSet for alphanum (join of alpha &amp; digit).
     * <p><blockquote><pre>
     *  alphanum      = alpha | digit
     * </pre></blockquote><p>
     */
    protected static final BitSet alphanum = new BitSet(256);
    // Static initializer for alphanum
    static {
        alphanum.or(alpha);
        alphanum.or(digit);
    }
 
 
    /**
     * BitSet for hex.
     * <p><blockquote><pre>
     * hex           = digit | "A" | "B" | "C" | "D" | "E" | "F" |
     *                         "a" | "b" | "c" | "d" | "e" | "f"
     * </pre></blockquote><p>
     */
    protected static final BitSet hex = new BitSet(256);
    // Static initializer for hex
    static {
        hex.or(digit);
        for (int i = 'a'; i <= 'f'; i++) {
            hex.set(i);
        }
        for (int i = 'A'; i <= 'F'; i++) {
            hex.set(i);
        }
    }
 
 
    /**
     * BitSet for escaped.
     * <p><blockquote><pre>
     * escaped       = "%" hex hex
     * </pre></blockquote><p>
     */
    protected static final BitSet escaped = new BitSet(256);
    // Static initializer for escaped
    static {
        escaped.or(percent);
        escaped.or(hex);
    }
 
 
    /**
     * BitSet for mark.
     * <p><blockquote><pre>
     * mark          = "-" | "_" | "." | "!" | "~" | "*" | "'" |
     *                 "(" | ")"
     * </pre></blockquote><p>
     */
    protected static final BitSet mark = new BitSet(256);
    // Static initializer for mark
    static {
        mark.set('-');
        mark.set('_');
        mark.set('.');
        mark.set('!');
        mark.set('~');
        mark.set('*');
        mark.set('\'');
        mark.set('(');
        mark.set(')');
    }
 
 
    /**
     * Data characters that are allowed in a URI but do not have a reserved
     * purpose are called unreserved.
     * <p><blockquote><pre>
     * unreserved    = alphanum | mark
     * </pre></blockquote><p>
     */
    protected static final BitSet unreserved = new BitSet(256);
    // Static initializer for unreserved
    static {
        unreserved.or(alphanum);
        unreserved.or(mark);
    }
 
 
    /**
     * BitSet for reserved.
     * <p><blockquote><pre>
     * reserved      = ";" | "/" | "?" | ":" | "@" | "&amp;" | "=" | "+" |
     *                 "$" | ","
     * </pre></blockquote><p>
     */
    protected static final BitSet reserved = new BitSet(256);
    // Static initializer for reserved
    static {
        reserved.set(';');
        reserved.set('/');
        reserved.set('?');
        reserved.set(':');
        reserved.set('@');
        reserved.set('&');
        reserved.set('=');
        reserved.set('+');
        reserved.set('$');
        reserved.set(',');
    }
 
 
    /**
     * BitSet for uric.
     * <p><blockquote><pre>
     * uric          = reserved | unreserved | escaped
     * </pre></blockquote><p>
     */
    protected static final BitSet uric = new BitSet(256);
    // Static initializer for uric
    static {
        uric.or(reserved);
        uric.or(unreserved);
        uric.or(escaped);
    }
 
 
    /**
     * BitSet for fragment (alias for uric).
     * <p><blockquote><pre>
     * fragment      = *uric
     * </pre></blockquote><p>
     */
    protected static final BitSet fragment = uric;
 
 
    /**
     * BitSet for query (alias for uric).
     * <p><blockquote><pre>
     * query         = *uric
     * </pre></blockquote><p>
     */
    protected static final BitSet query = uric;
 
 
    /**
     * BitSet for pchar.
     * <p><blockquote><pre>
     * pchar         = unreserved | escaped |
     *                 ":" | "@" | "&amp;" | "=" | "+" | "$" | ","
     * </pre></blockquote><p>
     */
    protected static final BitSet pchar = new BitSet(256);
    // Static initializer for pchar
    static {
        pchar.or(unreserved);
        pchar.or(escaped);
        pchar.set(':');
        pchar.set('@');
        pchar.set('&');
        pchar.set('=');
        pchar.set('+');
        pchar.set('$');
        pchar.set(',');
    }
 
 
    /**
     * BitSet for param (alias for pchar).
     * <p><blockquote><pre>
     * param         = *pchar
     * </pre></blockquote><p>
     */
    protected static final BitSet param = pchar;
 
 
    /**
     * BitSet for segment.
     * <p><blockquote><pre>
     * segment       = *pchar *( ";" param )
     * </pre></blockquote><p>
     */
    protected static final BitSet segment = new BitSet(256);
    // Static initializer for segment
    static {
        segment.or(pchar);
        segment.set(';');
        segment.or(param);
    }
 
 
    /**
     * BitSet for path segments.
     * <p><blockquote><pre>
     * path_segments = segment *( "/" segment )
     * </pre></blockquote><p>
     */
    protected static final BitSet path_segments = new BitSet(256);
    // Static initializer for path_segments
    static {
        path_segments.set('/');
        path_segments.or(segment);
    }
 
 
    /**
     * URI absolute path.
     * <p><blockquote><pre>
     * abs_path      = "/"  path_segments
     * </pre></blockquote><p>
     */
    protected static final BitSet abs_path = new BitSet(256);
    // Static initializer for abs_path
    static {
        abs_path.set('/');
        abs_path.or(path_segments);
    }
 
 
    /**
     * URI bitset for encoding typical non-slash characters.
     * <p><blockquote><pre>
     * uric_no_slash = unreserved | escaped | ";" | "?" | ":" | "@" |
     *                 "&amp;" | "=" | "+" | "$" | ","
     * </pre></blockquote><p>
     */
    protected static final BitSet uric_no_slash = new BitSet(256);
    // Static initializer for uric_no_slash
    static {
        uric_no_slash.or(unreserved);
        uric_no_slash.or(escaped);
        uric_no_slash.set(';');
        uric_no_slash.set('?');
        uric_no_slash.set(';');
        uric_no_slash.set('@');
        uric_no_slash.set('&');
        uric_no_slash.set('=');
        uric_no_slash.set('+');
        uric_no_slash.set('$');
        uric_no_slash.set(',');
    }
    
 
    /**
     * URI bitset that combines uric_no_slash and uric.
     * <p><blockquote><pre>
     * opaque_part   = uric_no_slash *uric
     * </pre></blockquote><p>
     */
    protected static final BitSet opaque_part = new BitSet(256);
    // Static initializer for opaque_part
    static {
        // it's generous. because first character must not include a slash
        opaque_part.or(uric_no_slash);
        opaque_part.or(uric);
    }
    
 
    /**
     * URI bitset that combines absolute path and opaque part.
     * <p><blockquote><pre>
     * path          = [ abs_path | opaque_part ]
     * </pre></blockquote><p>
     */
    protected static final BitSet path = new BitSet(256);
    // Static initializer for path
    static {
        path.or(abs_path);
        path.or(opaque_part);
    }
 
 
    /**
     * Port, a logical alias for digit.
     */
    protected static final BitSet port = digit;
 
 
    /**
     * Bitset that combines digit and dot fo IPv$address.
     * <p><blockquote><pre>
     * IPv4address   = 1*digit "." 1*digit "." 1*digit "." 1*digit
     * </pre></blockquote><p>
     */
    protected static final BitSet IPv4address = new BitSet(256);
    // Static initializer for IPv4address
    static {
        IPv4address.or(digit);
        IPv4address.set('.');
    }
 
 
    /**
     * RFC 2373.
     * <p><blockquote><pre>
     * IPv6address = hexpart [ ":" IPv4address ]
     * </pre></blockquote><p>
     */
    protected static final BitSet IPv6address = new BitSet(256);
    // Static initializer for IPv6address reference
    static {
        IPv6address.or(hex); // hexpart
        IPv6address.set(':');
        IPv6address.or(IPv4address);
    }
 
 
    /**
     * RFC 2732, 2373.
     * <p><blockquote><pre>
     * IPv6reference   = "[" IPv6address "]"
     * </pre></blockquote><p>
     */
    protected static final BitSet IPv6reference = new BitSet(256);
    // Static initializer for IPv6reference
    static {
        IPv6reference.set('[');
        IPv6reference.or(IPv6address);
        IPv6reference.set(']');
    }
 
 
    /**
     * BitSet for toplabel.
     * <p><blockquote><pre>
     * toplabel      = alpha | alpha *( alphanum | "-" ) alphanum
     * </pre></blockquote><p>
     */
    protected static final BitSet toplabel = new BitSet(256);
    // Static initializer for toplabel
    static {
        toplabel.or(alphanum);
        toplabel.set('-');
    }
 
 
    /**
     * BitSet for domainlabel.
     * <p><blockquote><pre>
     * domainlabel   = alphanum | alphanum *( alphanum | "-" ) alphanum
     * </pre></blockquote><p>
     */
    protected static final BitSet domainlabel = toplabel;
 
 
    /**
     * BitSet for hostname.
     * <p><blockquote><pre>
     * hostname      = *( domainlabel "." ) toplabel [ "." ]
     * </pre></blockquote><p>
     */
    protected static final BitSet hostname = new BitSet(256);
    // Static initializer for hostname
    static {
        hostname.or(toplabel);
        // hostname.or(domainlabel);
        hostname.set('.');
    }
 
 
    /**
     * BitSet for host.
     * <p><blockquote><pre>
     * host          = hostname | IPv4address | IPv6reference
     * </pre></blockquote><p>
     */
    protected static final BitSet host = new BitSet(256);
    // Static initializer for host
    static {
        host.or(hostname);
        // host.or(IPv4address);
        host.or(IPv6reference); // IPv4address
    }
 
 
    /**
     * BitSet for hostport.
     * <p><blockquote><pre>
     * hostport      = host [ ":" port ]
     * </pre></blockquote><p>
     */
    protected static final BitSet hostport = new BitSet(256);
    // Static initializer for hostport
    static {
        hostport.or(host);
        hostport.set(':');
        hostport.or(port);
    }
 
 
    /**
     * Bitset for userinfo.
     * <p><blockquote><pre>
     * userinfo      = *( unreserved | escaped |
     *                    ";" | ":" | "&amp;" | "=" | "+" | "$" | "," )
     * </pre></blockquote><p>
     */
    protected static final BitSet userinfo = new BitSet(256);
    // Static initializer for userinfo
    static {
        userinfo.or(unreserved);
        userinfo.or(escaped);
        userinfo.set(';');
        userinfo.set(':');
        userinfo.set('&');
        userinfo.set('=');
        userinfo.set('+');
        userinfo.set('$');
        userinfo.set(',');
    }
 
 
    /**
     * BitSet for within the userinfo component like user and password.
     */
    public static final BitSet within_userinfo = new BitSet(256);
    // Static initializer for within_userinfo
    static {
        within_userinfo.or(userinfo);
        within_userinfo.clear(';'); // reserved within authority
        within_userinfo.clear(':');
        within_userinfo.clear('@');
        within_userinfo.clear('?');
        within_userinfo.clear('/');
    }
 
 
    /**
     * Bitset for server.
     * <p><blockquote><pre>
     * server        = [ [ userinfo "@" ] hostport ]
     * </pre></blockquote><p>
     */
    protected static final BitSet server = new BitSet(256);
    // Static initializer for server
    static {
        server.or(userinfo);
        server.set('@');
        server.or(hostport);
    }
 
 
    /**
     * BitSet for reg_name.
     * <p><blockquote><pre>
     * reg_name      = 1*( unreserved | escaped | "$" | "," |
     *                     ";" | ":" | "@" | "&amp;" | "=" | "+" )
     * </pre></blockquote><p>
     */
    protected static final BitSet reg_name = new BitSet(256);
    // Static initializer for reg_name
    static {
        reg_name.or(unreserved);
        reg_name.or(escaped);
        reg_name.set('$');
        reg_name.set(',');
        reg_name.set(';');
        reg_name.set(':');
        reg_name.set('@');
        reg_name.set('&');
        reg_name.set('=');
        reg_name.set('+');
    }
 
 
    /**
     * BitSet for authority.
     * <p><blockquote><pre>
     * authority     = server | reg_name
     * </pre></blockquote><p>
     */
    protected static final BitSet authority = new BitSet(256);
    // Static initializer for authority
    static {
        authority.or(server);
        authority.or(reg_name);
    }
 
 
    /**
     * BitSet for scheme.
     * <p><blockquote><pre>
     * scheme        = alpha *( alpha | digit | "+" | "-" | "." )
     * </pre></blockquote><p>
     */
    protected static final BitSet scheme = new BitSet(256);
    // Static initializer for scheme
    static {
        scheme.or(alpha);
        scheme.or(digit);
        scheme.set('+');
        scheme.set('-');
        scheme.set('.');
    }
 
 
    /**
     * BitSet for rel_segment.
     * <p><blockquote><pre>
     * rel_segment   = 1*( unreserved | escaped |
     *                     ";" | "@" | "&amp;" | "=" | "+" | "$" | "," )
     * </pre></blockquote><p>
     */
    protected static final BitSet rel_segment = new BitSet(256);
    // Static initializer for rel_segment
    static {
        rel_segment.or(unreserved);
        rel_segment.or(escaped);
        rel_segment.set(';');
        rel_segment.set('@');
        rel_segment.set('&');
        rel_segment.set('=');
        rel_segment.set('+');
        rel_segment.set('$');
        rel_segment.set(',');
    }
 
 
    /**
     * BitSet for rel_path.
     * <p><blockquote><pre>
     * rel_path      = rel_segment [ abs_path ]
     * </pre></blockquote><p>
     */
    protected static final BitSet rel_path = new BitSet(256);
    // Static initializer for rel_path
    static {
        rel_path.or(rel_segment);
        rel_path.or(abs_path);
    }
 
 
    /**
     * BitSet for net_path.
     * <p><blockquote><pre>
     * net_path      = "//" authority [ abs_path ]
     * </pre></blockquote><p>
     */
    protected static final BitSet net_path = new BitSet(256);
    // Static initializer for net_path
    static {
        net_path.set('/');
        net_path.or(authority);
        net_path.or(abs_path);
    }
    
 
    /**
     * BitSet for hier_part.
     * <p><blockquote><pre>
     * hier_part     = ( net_path | abs_path ) [ "?" query ]
     * </pre></blockquote><p>
     */
    protected static final BitSet hier_part = new BitSet(256);
    // Static initializer for hier_part
    static {
        hier_part.or(net_path);
        hier_part.or(abs_path);
        // hier_part.set('?'); aleady included
        hier_part.or(query);
    }
 
 
    /**
     * BitSet for relative
     * <p><blockquote><pre>
     * relativeURI   = ( net_path | abs_path | rel_path ) [ "?" query ]
     * </pre></blockquote><p>
     */
    protected static final BitSet relativeURI = new BitSet(256);
    // Static initializer for relativeURI
    static {
        relativeURI.or(net_path);
        relativeURI.or(abs_path);
        relativeURI.or(rel_path);
        // relativeURI.set('?'); aleady included
        relativeURI.or(query);
    }
 
 
    /**
     * BitSet for absoluteURI.
     * <p><blockquote><pre>
     * absoluteURI   = scheme ":" ( hier_part | opaque_part )
     * </pre></blockquote><p>
     */
    protected static final BitSet absoluteURI = new BitSet(256);
    // Static initializer for absoluteURI
    static {
        absoluteURI.or(scheme);
        absoluteURI.set(':');
        absoluteURI.or(hier_part);
        absoluteURI.or(opaque_part);
    }
 
 
    /**
     * BitSet for URI-reference.
     * <p><blockquote><pre>
     * URI-reference = [ absoluteURI | relativeURI ] [ "#" fragment ]
     * </pre></blockquote><p>
     */
    protected static final BitSet URI_reference = new BitSet(256);
    // Static initializer for URI_reference
    static {
        URI_reference.or(absoluteURI);
        URI_reference.or(relativeURI);
        URI_reference.set('#');
        URI_reference.or(fragment);
    }
 
    // ---------------------------- Characters disallowed within the URI syntax
    // Excluded US-ASCII Characters are like control, space, delims and unwise
 
    /**
     * BitSet for control.
     */
    public static final BitSet control = new BitSet(256);
    // Static initializer for control
    static {
        for (int i = 0; i <= 0x1F; i++) {
            control.set(i);
        }
        control.set(0x7F);
    }
 
    /**
     * BitSet for space.
     */
    public static final BitSet space = new BitSet(256);
    // Static initializer for space
    static {
        space.set(0x20);
    }
 
 
    /**
     * BitSet for delims.
     */
    public static final BitSet delims = new BitSet(256);
    // Static initializer for delims
    static {
        delims.set('<');
        delims.set('>');
        delims.set('#');
        delims.set('%');
        delims.set('"');
    }
 
 
    /**
     * BitSet for unwise.
     */
    public static final BitSet unwise = new BitSet(256);
    // Static initializer for unwise
    static {
        unwise.set('{');
        unwise.set('}');
        unwise.set('|');
        unwise.set('\\');
        unwise.set('^');
        unwise.set('[');
        unwise.set(']');
        unwise.set('`');
    }
 
 
    /**
     * Disallowed rel_path before escaping.
     */
    public static final BitSet disallowed_rel_path = new BitSet(256);
    // Static initializer for disallowed_rel_path
    static {
        disallowed_rel_path.or(uric);
        disallowed_rel_path.andNot(rel_path);
    }
 
 
    /**
     * Disallowed opaque_part before escaping.
     */
    public static final BitSet disallowed_opaque_part = new BitSet(256);
    // Static initializer for disallowed_opaque_part
    static {
        disallowed_opaque_part.or(uric);
        disallowed_opaque_part.andNot(opaque_part);
    }
 
    // ----------------------- Characters allowed within and for each component
 
    /**
     * Those characters that are allowed for the authority component.
     */
    public static final BitSet allowed_authority = new BitSet(256);
    // Static initializer for allowed_authority
    static {
        allowed_authority.or(authority);
        allowed_authority.clear('%');
    }
 
 
    /**
     * Those characters that are allowed for the opaque_part.
     */
    public static final BitSet allowed_opaque_part = new BitSet(256);
    // Static initializer for allowed_opaque_part 
    static {
        allowed_opaque_part.or(opaque_part);
        allowed_opaque_part.clear('%');
    }
 
 
    /**
     * Those characters that are allowed for the reg_name.
     */
    public static final BitSet allowed_reg_name = new BitSet(256);
    // Static initializer for allowed_reg_name 
    static {
        allowed_reg_name.or(reg_name);
        // allowed_reg_name.andNot(percent);
        allowed_reg_name.clear('%');
    }
 
 
    /**
     * Those characters that are allowed for the userinfo component.
     */
    public static final BitSet allowed_userinfo = new BitSet(256);
    // Static initializer for allowed_userinfo
    static {
        allowed_userinfo.or(userinfo);
        // allowed_userinfo.andNot(percent);
        allowed_userinfo.clear('%');
    }
 
 
    /**
     * Those characters that are allowed for within the userinfo component.
     */
    public static final BitSet allowed_within_userinfo = new BitSet(256);
    // Static initializer for allowed_within_userinfo
    static {
        allowed_within_userinfo.or(within_userinfo);
        allowed_within_userinfo.clear('%');
    }
 
 
    /**
     * Those characters that are allowed for the IPv6reference component.
     * The characters '[', ']' in IPv6reference should be excluded.
     */
    public static final BitSet allowed_IPv6reference = new BitSet(256);
    // Static initializer for allowed_IPv6reference
    static {
        allowed_IPv6reference.or(IPv6reference);
        // allowed_IPv6reference.andNot(unwise);
        allowed_IPv6reference.clear('[');
        allowed_IPv6reference.clear(']');
    }
 
 
    /**
     * Those characters that are allowed for the host component.
     * The characters '[', ']' in IPv6reference should be excluded.
     */
    public static final BitSet allowed_host = new BitSet(256);
    // Static initializer for allowed_host
    static {
        allowed_host.or(hostname);
        allowed_host.or(allowed_IPv6reference);
    }
 
 
    /**
     * Those characters that are allowed for the authority component.
     */
    public static final BitSet allowed_within_authority = new BitSet(256);
    // Static initializer for allowed_within_authority
    static {
        allowed_within_authority.or(server);
        allowed_within_authority.or(reg_name);
        allowed_within_authority.clear(';');
        allowed_within_authority.clear(':');
        allowed_within_authority.clear('@');
        allowed_within_authority.clear('?');
        allowed_within_authority.clear('/');
    }
 
 
    /**
     * Those characters that are allowed for the abs_path.
     */
    public static final BitSet allowed_abs_path = new BitSet(256);
    // Static initializer for allowed_abs_path
    static {
        allowed_abs_path.or(abs_path);
        // allowed_abs_path.set('/');  // aleady included
        allowed_abs_path.andNot(percent);
        allowed_abs_path.clear('+');
    }
 
 
    /**
     * Those characters that are allowed for the rel_path.
     */
    public static final BitSet allowed_rel_path = new BitSet(256);
    // Static initializer for allowed_rel_path
    static {
        allowed_rel_path.or(rel_path);
        allowed_rel_path.clear('%');
        allowed_rel_path.clear('+');
    }
 
 
    /**
     * Those characters that are allowed within the path.
     */
    public static final BitSet allowed_within_path = new BitSet(256);
    // Static initializer for allowed_within_path
    static {
        allowed_within_path.or(abs_path);
        allowed_within_path.clear('/');
        allowed_within_path.clear(';');
        allowed_within_path.clear('=');
        allowed_within_path.clear('?');
    }
 
 
    /**
     * Those characters that are allowed for the query component.
     */
    public static final BitSet allowed_query = new BitSet(256);
    // Static initializer for allowed_query
    static {
        allowed_query.or(uric);
        allowed_query.clear('%');
    }
 
 
    /**
     * Those characters that are allowed within the query component.
     */
    public static final BitSet allowed_within_query = new BitSet(256);
    // Static initializer for allowed_within_query
    static {
        allowed_within_query.or(allowed_query);
        allowed_within_query.andNot(reserved); // excluded 'reserved'
    }
 
 
    /**
     * Those characters that are allowed for the fragment component.
     */
    public static final BitSet allowed_fragment = new BitSet(256);
    // Static initializer for allowed_fragment
    static {
        allowed_fragment.or(uric);
        allowed_fragment.clear('%');
    }
    
        
    public static class URIException extends Exception {
 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
 
		public URIException() {
			super();
			// TODO Auto-generated constructor stub
		}
 
		public URIException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}
 
		public URIException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
 
		public URIException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
    	
    }
 
}