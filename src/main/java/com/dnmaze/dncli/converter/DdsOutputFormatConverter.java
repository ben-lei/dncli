package com.dnmaze.dncli.converter;

import com.dnmaze.dncli.enums.DdsOutputFormat;
import com.dnmaze.dncli.exception.InvalidDdsOutputFormatException;

import com.beust.jcommander.IStringConverter;

/**
 * Created by blei on 6/16/16.
 */
public class DdsOutputFormatConverter implements IStringConverter<DdsOutputFormat> {
  @Override
  public DdsOutputFormat convert(String value) {
    if (value == null) {
      throw new InvalidDdsOutputFormatException("nothing was provided");
    }

    value = value.toLowerCase();
    if ("png".equals(value)) {
      return DdsOutputFormat.png;
    } else if ("jpg".equals(value)) {
      return DdsOutputFormat.jpg;
    }

    throw new InvalidDdsOutputFormatException("invalid output format: " + value);
  }
}
