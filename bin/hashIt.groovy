#! /usr/bin/env groovy

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Hasher {

char[] HEX_DIGITS = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
String encodingAlgorithm = 'MD5'
String characterEncoding ='UTF-8'

String getFormattedText(final byte[] bytes) {
    final StringBuilder buf = new StringBuilder(bytes.length * 2);

    for (int j = 0; j < bytes.length; j++) {
      buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
      buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
    }
    return buf.toString();
  }

String encode(CharSequence password)
{

  if (password == null) {
    return null;
  }

  try {
    MessageDigest messageDigest = MessageDigest.getInstance(this.encodingAlgorithm);

    messageDigest.update(password.getBytes(this.characterEncoding));
    
    final byte[] digest = messageDigest.digest();

    return this.getFormattedText(digest);
  } catch (final NoSuchAlgorithmException e) {
    throw new SecurityException(e);
  } catch (final UnsupportedEncodingException e) {
    throw new RuntimeException(e);
  }
}
}

def hasher = new Hasher()
def x = hasher.encode(args[0].toString())
println "${args[0].toString()} : ${x}"

