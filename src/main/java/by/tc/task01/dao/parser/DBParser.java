package by.tc.task01.dao.parser;

import by.tc.task01.exception.DatabaseParserException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DBParser {

    private static final DBParser INSTANCE = new DBParser();

    private static final Path PATH_DB = Path.of("src", "main", "resources", "appliances_db.txt");

    private static final Integer NAME_POSITION_IN_DB = 0;
    private static final Integer VALUE_POSITION_IN_DB = 1;

    private static final String REGEX_GROUP = "\\w+:";
    private static final String REGEX_SPACE = "\\s+";
    private static final String REGEX_GROUP_SPLITERATOR = ":";
    private static final String REGEX_LINE_SPLITERATOR = ";";
    private static final String REGEX_VALUE_SPLITERATOR = "=";
    private static final String REGEX_SPECIFICATION_SPLITERATOR = ",";
    private static final String REGEX_EMPTY = "";

    private static final List<String> DATABASE_LINES = new ArrayList<>();

    static {
        loadLinesFromDB();
    }

    private DBParser() {
    }

    private static void loadLinesFromDB() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(PATH_DB)) {
            while (bufferedReader.ready()) {
                String info = bufferedReader.readLine();
                DATABASE_LINES.add(info);
            }
        } catch (IOException e) {
            throw new DatabaseParserException();
        }
    }

    public List<String> getDatabaseLinesByGroup(String groupName) {
        List<String> linesByGroup = new ArrayList<>();
        for (String line : DATABASE_LINES) {
            if (line.startsWith(groupName)) {
                linesByGroup.add(line);
            }
        }
        return linesByGroup;
    }

    public static String defineApplianceGroup(String info) {
        String lineWithoutSpaces = info.replaceAll(REGEX_SPACE, REGEX_EMPTY);
        Pattern pattern = Pattern.compile(REGEX_GROUP);
        Matcher matcher = pattern.matcher(lineWithoutSpaces);
        String group = null;
        if (matcher.find()) {
            group = matcher.group().replaceAll(REGEX_GROUP_SPLITERATOR, REGEX_EMPTY);
        }
        return group;
    }

    public static Map<String, Object> parseLineToSpecification(String info) {
        Map<String, Object> specificationFromDB = new HashMap<>();
        String lineWithReplaces = info.replaceAll(REGEX_SPACE, REGEX_EMPTY)
                .replaceAll(REGEX_GROUP, REGEX_EMPTY)
                .replace(REGEX_LINE_SPLITERATOR, REGEX_EMPTY);
        String[] specifications = lineWithReplaces.split(REGEX_SPECIFICATION_SPLITERATOR);
        for (String specification : specifications) {
            String[] nameAndValue = specification.split(REGEX_VALUE_SPLITERATOR);
            specificationFromDB.put(nameAndValue[NAME_POSITION_IN_DB], nameAndValue[VALUE_POSITION_IN_DB]);
        }
        return specificationFromDB;
    }

    public static String objToString(Map<String, Object> specificationFromDB, String criteriaName) {
        return (String) specificationFromDB.get(criteriaName);
    }

    public static Integer objToInt(Map<String, Object> specificationFromDB, String criteriaName) {
        return Integer.parseInt((String) specificationFromDB.get(criteriaName));
    }

    public static Double objToDouble(Map<String, Object> specificationFromDB, String criteriaName) {
        return Double.parseDouble((String) specificationFromDB.get(criteriaName));
    }

    public static DBParser getInstance() {
        return INSTANCE;
    }

    public List<String> getDatabaseLines() {
        return DATABASE_LINES;
    }
}
