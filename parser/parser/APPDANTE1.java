package net.osgg.parser;

import java.io.IOException;

/**
 * Example adapted from http://www.javapractices.com/topic/TopicAction.do?Id=87
 *
 */
public class APPDANTE1 {
    public static void main(String[] args) throws IOException {
        ReadWithTokenizer parser = new ReadWithTokenizer("TEXTOPRUEBA.txt");
        parser.processLineByLine();
        parser.printWordCounts();
    }
}

