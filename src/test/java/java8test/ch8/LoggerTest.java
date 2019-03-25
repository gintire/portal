package java8test.ch8;

import com.gintire.java8.vo.AirPollutionLevel;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.ibatis.common.logging.Log;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggerTest {
    private final static Logger logger = Logger.getGlobal();
    // legacy

    public static void main(String[] args) {
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("problem : " + generateDiagnostic());
        }
        logger.log(Level.FINER, ()->"problem : "+ generateDiagnostic());
        airCheck(AirPollutionLevel.Good, ()->"Yes I alive");
    }

    public static String generateDiagnostic() {
         return "a";
    }

    public static void airCheck(AirPollutionLevel level, Supplier<String> msgSupplier) {
        if(!Air.isAlive(level)) {
            return;
        }
        System.out.println(msgSupplier.get());
    }
}

class Air {
    public static boolean isAlive(AirPollutionLevel level) {
        if (level.intValue() > 150) {
            return false;
        }
        return true;
    }
}
