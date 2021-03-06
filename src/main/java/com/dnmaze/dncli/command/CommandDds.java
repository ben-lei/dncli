package com.dnmaze.dncli.command;

import com.dnmaze.dncli.converter.DdsOutputFormatConverter;
import com.dnmaze.dncli.dds.DdsConverter;
import com.dnmaze.dncli.enums.DdsOutputFormat;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blei on 6/15/16.
 */
@Parameters(commandNames = "dds",
    commandDescription = "Microsoft DDS to JPG/PNG converter. It is recommended to use "
        + "ImageMagick if it's already installed.")
public class CommandDds implements Runnable {
  private final Runnable runner = new DdsConverter(this);

  @Getter
  @Parameter(names = "-force",
      description = "Forces overwriting of converted file without confirmation")
  private boolean force;

  @Getter
  @Parameter(names = "-format",
      description = "The output file format. Valid options are png and jpg.",
      converter = DdsOutputFormatConverter.class,
      required = true)
  private DdsOutputFormat format;

  @Getter
  @Parameter(names = "-quiet", description = "Quiet output")
  private boolean quiet;

  @Getter
  @Parameter(names = "-favor-dark",
      description = "Specifically for DN skill trees. Basically highlights the black colors, "
                    + "removing less black colors from the image.")
  private boolean favorDark;

  @Getter
  @Parameter(names = "-border",
      description = "Specifically for DN skill image borders. Basically makes multiple colored "
                    + "versions of the border in the same image.")
  private boolean border;

  @Getter
  @Parameter(names = "-output",
      description = "Output contents to provided file.",
      converter = FileConverter.class)
  private File output;

  @Getter
  @Parameter(description = "ddsFiles...", converter = FileConverter.class)
  private List<File> files = new ArrayList<>();

  @Parameter(names = "-help", description = "Displays this usage.", help = true)
  @Getter
  private boolean help;

  @Override
  public void run() {
    runner.run();
  }
}
