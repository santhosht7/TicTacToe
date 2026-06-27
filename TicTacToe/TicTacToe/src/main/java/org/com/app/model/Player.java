package org.com.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.com.app.enums.PlayerType;

@AllArgsConstructor
@Getter
public abstract class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
}
