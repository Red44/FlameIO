package de.flamefoxes.flameio.result;

import de.flamefoxes.lib.time.UnixTime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public enum DefaultClass {
  BIG_DECIMAL(BigDecimal.class),
  BigInteger(BigInteger.class),
  BOOLEAN(Boolean.class),
  CHARACTER(Character.class),
  TIME(UnixTime.class),
  DOUBLE(Double.class),
  FLOAT(Float.class),
  INTEGER(Integer.class),
  LONG(Long.class),
  SHORT(Short.class),
  STRING(String.class),
  UUID(UUID.class);

  private final Class<?> clazz;

  private DefaultClass(Class<?> clazz){
    this.clazz = clazz;
  }

  public Class<?> getClassValue(){
    return clazz;
  }
}
