package com.ooad.demo.POJO.BO;

import com.ooad.demo.Entity.*;

import java.util.List;

/**
 * @Description:如类名所示
 * @Author:17Wang
 * @Time:13:30 2018/12/2
*/
public class PresentationTeamBO {
    private Presentation presentation;
    private Team team;

    public PresentationTeamBO(Presentation presentation, Team team) {
        this.presentation = presentation;
        this.team = team;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
