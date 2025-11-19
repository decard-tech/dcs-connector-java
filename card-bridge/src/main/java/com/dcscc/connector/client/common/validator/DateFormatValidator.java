/*
 * dcs Java Connector
 * Date format validator utility
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

/**
 * Utility class for validating date formats.
 * 
 * <p>This class provides methods to validate various date formats
 * commonly used in the DCS API.
 * 
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public final class DateFormatValidator {

    /**
     * Pattern for yyyyMMdd format.
     */
    private static final Pattern YYYYMMDD_PATTERN = Pattern.compile("^\\d{8}$");
    
    /**
     * DateTimeFormatter for yyyyMMdd format.
     */
    private static final DateTimeFormatter YYYYMMDD_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * Private constructor to prevent instantiation.
     */
    private DateFormatValidator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Validates if the given string is in yyyyMMdd format.
     *
     * @param dateString the date string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidYyyyMmDd(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return false;
        }

        // Check pattern first
        if (!YYYYMMDD_PATTERN.matcher(dateString).matches()) {
            return false;
        }

        // Try to parse the date
        try {
            LocalDate.parse(dateString, YYYYMMDD_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Validates and parses a yyyyMMdd date string.
     *
     * @param dateString the date string to parse
     * @return the parsed LocalDate
     * @throws IllegalArgumentException if the date string is invalid
     */
    public static LocalDate parseYyyyMmDd(String dateString) {
        if (!isValidYyyyMmDd(dateString)) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyyMMdd, got: " + dateString);
        }

        try {
            return LocalDate.parse(dateString, YYYYMMDD_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date: " + dateString, e);
        }
    }

    /**
     * Formats a LocalDate to yyyyMMdd string.
     *
     * @param date the date to format
     * @return the formatted date string
     * @throws IllegalArgumentException if date is null
     */
    public static String formatYyyyMmDd(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.format(YYYYMMDD_FORMATTER);
    }

    /**
     * Validates if the date is within a reasonable range (not too far in the past or future).
     *
     * @param dateString the date string to validate
     * @param maxYearsInPast maximum years in the past (e.g., 10)
     * @param maxYearsInFuture maximum years in the future (e.g., 1)
     * @return true if within range, false otherwise
     */
    public static boolean isWithinReasonableRange(String dateString, int maxYearsInPast, int maxYearsInFuture) {
        if (!isValidYyyyMmDd(dateString)) {
            return false;
        }

        LocalDate date = parseYyyyMmDd(dateString);
        LocalDate now = LocalDate.now();
        LocalDate minDate = now.minusYears(maxYearsInPast);
        LocalDate maxDate = now.plusYears(maxYearsInFuture);

        return !date.isBefore(minDate) && !date.isAfter(maxDate);
    }
}
