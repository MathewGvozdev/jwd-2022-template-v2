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
        loadDatabaseToList();
    }

    private DBParser() {
    }

    private static void loadDatabaseToList() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(PATH_DB)) {
            while (bufferedReader.ready()) {
                String applianceInfo = bufferedReader.readLine();
                DATABASE_LINES.add(applianceInfo);
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

    public static String defineApplianceGroup(String applianceInfo) {
        String lineWithoutSpaces = applianceInfo.replaceAll(REGEX_SPACE, REGEX_EMPTY);
        Pattern applianceGroupPattern = Pattern.compile(REGEX_GROUP);
        Matcher applianceGroupMatcher = applianceGroupPattern.matcher(lineWithoutSpaces);
        String applianceGroupName = null;
        if (applianceGroupMatcher.find()) {
            applianceGroupName = applianceGroupMatcher.group().replaceAll(REGEX_GROUP_SPLITERATOR, REGEX_EMPTY);
        }
        return applianceGroupName;
    }

    public static Map<String, Object> parseLineToSpecification(String applianceInfo) {
        Map<String, Object> specificationFromDB = new HashMap<>();
        String lineWithReplaces = applianceInfo.replaceAll(REGEX_SPACE, REGEX_EMPTY)
                .replaceAll(REGEX_GROUP, REGEX_EMPTY)
                .replace(REGEX_LINE_SPLITERATOR, REGEX_EMPTY);
        String[] specifications = lineWithReplaces.split(REGEX_SPECIFICATION_SPLITERATOR);
        for (String specification : specifications) {
            String[] nameAndValue = specification.split(REGEX_VALUE_SPLITERATOR);
            specificationFromDB.put(nameAndValue[NAME_POSITION_IN_DB], nameAndValue[VALUE_POSITION_IN_DB]);
        }
        return specificationFromDB;
    }

    public static DBParser getInstance() {
        return INSTANCE;
    }

    public List<String> getDatabaseLines() {
        return DATABASE_LINES;
    }
}
