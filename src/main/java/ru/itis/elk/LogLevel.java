package ru.itis.elk;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogLevel {
    ERROR("Error"),
    WARN("Warn"),
    INFO("Info"),
    DEBUG("Debug"),
    TRACE("Trace");

    private final String name;
}
