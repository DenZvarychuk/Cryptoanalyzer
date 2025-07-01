package org.cryptoanalyzer.app;

import org.cryptoanalyzer.input.Input;
import org.cryptoanalyzer.result.Output;
import org.cryptoanalyzer.services.BasicCesarEncode;
import org.cryptoanalyzer.result.Result;

import java.io.IOException;

public class Application {

    Result result = new Result("", 0);

    public void run() throws IOException {


        Input input = new Input();
        result = input.readInput(result);

        BasicCesarEncode encoder = new BasicCesarEncode();
        result.setEncodedLine(encoder.encode(result.getInitialLine(), result.getKey()));

        Output out = new Output();
        out.showResult(result);

    }
}
