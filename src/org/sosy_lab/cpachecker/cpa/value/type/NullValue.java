/*
 * IntPTI: integer error fixing by proper-type inference
 * Copyright (c) 2017.
 *
 * Open-source component:
 *
 * CPAchecker
 * Copyright (C) 2007-2014  Dirk Beyer
 *
 * Guava: Google Core Libraries for Java
 * Copyright (C) 2010-2006  Google
 *
 *
 */
package org.sosy_lab.cpachecker.cpa.value.type;

import org.sosy_lab.cpachecker.cfa.types.c.CType;

/**
 * Singleton class for the special value <code>null</code>.
 */
public class NullValue implements Value {

  private static final long serialVersionUID = 49593725475613735L;

  private static final NullValue SINGLETON = new NullValue();

  private NullValue() {
    // private constructor for singleton pattern
  }

  /**
   * Returns an instance of a <code>NullValue</code> object.
   *
   * @return an instance of this object
   */
  public static Value getInstance() {
    return SINGLETON;
  }

  /**
   * Always returns <code>false</code> since <code>null</code> is no numeric value.
   *
   * @return always returns <code>false</code>
   */
  @Override
  public boolean isNumericValue() {
    return false;
  }

  /**
   * Always returns <code>false</code> since <code>null</code> is a specific value.
   *
   * @return always returns <code>false</code>
   */
  @Override
  public boolean isUnknown() {
    return false;
  }

  /**
   * Always returns <code>true</code> since <code>null</code> is a specific value.
   */
  @Override
  public boolean isExplicitlyKnown() {
    return true;
  }

  /**
   * This method always returns <code>null</code>.
   *
   * <p>This object always represents <code>null</code>, which can't be
   * represented by a specific numeric value.</p>
   */
  @Override
  public NumericValue asNumericValue() {
    return null;
  }

  /**
   * This method is not implemented and will lead to an <code>AssertionError</code>.
   * <code>Null</code> can't be represented by a specific number.
   */
  @Override
  public Long asLong(CType pType) {
    throw new AssertionError("Null cannot be represented as Long");
  }

  @Override
  public boolean equals(Object other) {

    // all NullValue objects are equal
    return other instanceof NullValue;
  }

  @Override
  public int hashCode() {
    return 1; // singleton without any values
  }

  @Override
  public String toString() {
    return "NULL";
  }
}
