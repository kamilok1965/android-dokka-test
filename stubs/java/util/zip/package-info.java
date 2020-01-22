/**
 * Provides classes for reading and writing the standard ZIP and GZIP
 * file formats.  Also includes classes for compressing and decompressing
 * data using the DEFLATE compression algorithm, which is used by the
 * ZIP and GZIP file formats. Additionally, there are utility classes
 * for computing the CRC-32 and Adler-32 checksums of arbitrary
 * input streams.
 *
 *
 * <h2>Package Specification</h2>
 *
 * </a>
 * <ul>
 *   <li><a href="http://www.info-zip.org/doc/appnote-19970311-iz.zip">
 *       Info-ZIP Application Note 970311
 *       </a> - a detailed description of the Info-ZIP format upon which
 *       the <code>java.util.zip</code> classes are based.
 * <p>
 *   <a name="zip64">
 *   <li>An implementation may optionally support the ZIP64(tm) format extensions
 *       defined by the
 *       <a href="http://www.pkware.com/documents/casestudies/APPNOTE.TXT">
 *       PKWARE ZIP File Format Specification</a>. The ZIP64(tm) format extensions
 *       are used to overcome the size limitations of the original ZIP format.
 * <p>
 *   <a name="lang_encoding">
 *   <li>APPENDIX D of <a href="http://www.pkware.com/documents/casestudies/APPNOTE.TXT">
 *       PKWARE ZIP File Format Specification</a> - Language Encoding Flag (EFS) to
 *       encode ZIP entry filename and comment fields using UTF-8.
 * <p>
 *   <li><a href="http://www.ietf.org/rfc/rfc1950.txt">
 *       ZLIB Compressed Data Format Specification version 3.3</a>
 *       &nbsp;
 *       <a href="http://www.ietf.org/rfc/rfc1950.txt.pdf">(pdf)</a>
 *       (RFC 1950)
 * <p>
 *   <li><a href="http://www.ietf.org/rfc/rfc1951.txt">
 *       DEFLATE Compressed Data Format Specification version 1.3</a>
 *       &nbsp;
 *       <a href="http://www.ietf.org/rfc/rfc1951.txt.pdf">(pdf)</a>
 *       (RFC 1951)
 * <p>
 *   <li><a href="http://www.ietf.org/rfc/rfc1952.txt">
 *       GZIP file format specification version 4.3</a>
 *       &nbsp;
 *       <a href="http://www.ietf.org/rfc/rfc1952.txt.pdf">(pdf)</a>
 *       (RFC 1952)
 * <p>
 *   <li>CRC-32 checksum is described in RFC 1952 (above)
 * <p>
 *   <li>Adler-32 checksum is described in RFC 1950 (above)
 * </ul>
 *
 *
 * <!--
 * <h2>Related Documentation</h2>
 *
 * For overviews, tutorials, examples, guides, and tool documentation, please see:
 * <ul>
 *   <li><a href="">##### REFER TO NON-SPEC DOCUMENTATION HERE #####</a>
 * </ul>
 * -->
 *
 * @since JDK1.1
 @apiSince 1
 */

package java.util.zip;
