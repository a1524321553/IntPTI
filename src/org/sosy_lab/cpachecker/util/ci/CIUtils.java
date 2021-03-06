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
package org.sosy_lab.cpachecker.util.ci;

import com.google.common.base.Function;


public class CIUtils {

  private CIUtils() {
  }

  public static String getSMTName(final String varName) {
    if (varName.contains(":")) {
      return "|" + varName + "|";
    }
    return varName;
  }

  public static final Function<String, String> GET_SMTNAME = new Function<String, String>() {
    @Override
    public String apply(final String varName) {
      return getSMTName(varName);
    }
  };

  public static final Function<String, String> GET_SMTNAME_WITH_INDEX =
      new Function<String, String>() {
        @Override
        public String apply(final String varName) {
          return getSMTName(varName + "@1");
        }
      };

}
