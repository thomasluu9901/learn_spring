package com.vn.learn.java.ultil.lexorank.system;

public interface LexoNumeralSystem {

  String getName();

  int getBase();

  char getPositiveChar();

  char getNegativeChar();

  char getRadixPointChar();

  int toDigit(char var1);

  char toChar(int var1);
}
