package by.tc.task01.dao.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DBParser {

    private static final Integer NAME_POSITION_IN_DB = 0;
    private static final Integer VALUE_POSITION_IN_DB = 1;

    private static final String REGEX_GROUP = "\\w+:";
    private static final String REGEX_SPACE = "\\s+";
    private static final String REGEX_GROUP_SPLITERATOR = ":";
    private static final String REGEX_LINE_SPLITERATOR = ";";
    private static final String REGEX_VALUE_SPLITERATOR = "=";
    private static final String REGEX_SPECIFICATION_SPLITERATOR = ",";

    private DBParser(){
    }

    public static String defineApplianceGroup(String info) {
        String infoStr = info.replaceAll(REGEX_SPACE, "");
        Pattern pattern = Pattern.compile(REGEX_GROUP);
        Matcher matcher = pattern.matcher(infoStr);
        String group = null;
        if (matcher.find()) {
            group = matcher.group().replaceAll(REGEX_GROUP_SPLITERATOR, "");
        }
        return group;
    }

    public static Map<String, Object> parseLineToSpecification(String info) {
        Map<String, Object> specificationFromDB = new HashMap<>();
        String lineWithReplaces = info.replaceAll(REGEX_SPACE, "")
                .replaceAll(REGEX_GROUP, "")
                .replace(REGEX_LINE_SPLITERATOR, "");
        String[] specifications = lineWithReplaces.split(REGEX_SPECIFICATION_SPLITERATOR);
        for (String specification : specifications) {
            String[] nameAndValue = specification.split(REGEX_VALUE_SPLITERATOR);
            specificationFromDB.put(nameAndValue[NAME_POSITION_IN_DB], nameAndValue[VALUE_POSITION_IN_DB]);
        }
        return specificationFromDB;
    }

    public static String toString(Map<String, Object> specificationFromDB, String criteriaName) {
        return (String) specificationFromDB.get(criteriaName);
    }

    public static Integer toInt(Map<String, Object> specificationFromDB, String criteriaName) {
        return Integer.parseInt((String) specificationFromDB.get(criteriaName));
    }

    public static Double toDouble(Map<String, Object> specificationFromDB, String criteriaName) {
        return Double.parseDouble((String) specificationFromDB.get(criteriaName));
    }
}
