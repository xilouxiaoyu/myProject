package com.team.com.team.service;

import com.team.com.team.domain.Architect;
import com.team.com.team.domain.Designer;
import com.team.com.team.domain.Employee;
import com.team.com.team.domain.Programmer;

public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < team.length; i++){
            team[i] =this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该员工已在开发团队中，");
        }
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("BUVOCATIONSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假，无法添加");
        }
        int numofArch = 0, numofDesi = 0, numofProg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numofArch++;
            } else if (team[i] instanceof Designer) {
                numofDesi++;
            } else if (team[i] instanceof Programmer) {
                numofProg++;
            }
        }

        if (p instanceof Architect) {
            if (numofArch >= 1) {
                throw new TeamException("团队中至多有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numofDesi >= 2) {
                throw new TeamException("团队中至多有两2名设计师");
            }

        } else if (p instanceof Programmer) {
            if (numofProg >= 3) {
                throw new TeamException("团队中至多有两3名程序员");
            }
        }
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    public boolean isExist(Employee e){
        for(int i = 0; i < total; i++){
            if(team[i].getId() == e.getId()) return true;
        }
        return false;

    }

    public void removeMeber(int memberId) throws TeamException{
        int i = 0;
        for(;i < total; i++){
            if(team[i].getId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total){
            throw new TeamException("找不到指定的memberID，删除失败");
        }
        for(int j = i + 1; j < total; j++){
            team[j-1] = team[j];

        }

        team[total-1] = null;
        total--;
    }
}
