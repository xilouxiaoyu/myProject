package com.team.com.team.view;

import com.team.com.team.domain.Employee;
import com.team.com.team.domain.Programmer;
import com.team.com.team.service.NameListService;
import com.team.com.team.service.TeamException;
import com.team.com.team.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {

        Boolean loop = true;
        char menu ='0';

        while (loop) {
            if(menu !='1'){
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();

            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("是否要退出 Y/N");
                    char c = TSUtility.readConfirmSelection();
                    if(c == 'Y'){
                        loop = false;
                    }
                    break;
            }
        }
    }

        private void listAllEmployees(){
            System.out.println("显示公司所有的员工");
            Employee[] allEmployees = listSvc.getAllEmployees();
            for(Employee employee:allEmployees){
                System.out.println(employee);
            }
        }

        private void getTeam(){
            System.out.println("查看团队成员");
            Programmer[] team = teamSvc.getTeam();
            for(Programmer teamer : team){
                System.out.println(teamer.getDetailForTeam());
            }
        }

        private void addMember(){
            System.out.println("添加成员");
            int i = TSUtility.readInt();
            try {
                Employee employee1 = listSvc.getEmployee(i);
                teamSvc.addMember(employee1);
            }catch (TeamException e){
                System.out.println(e.getMessage());
            }
            TSUtility.readReturn();
        }

        private void deleteMember(){
            System.out.println("删除成员");
            int memberId = TSUtility.readInt();
            System.out.println("是否删除 Y/N");
            char isDelete = TSUtility.readConfirmSelection();
            if(isDelete== 'N') {
                return;
            }
            try {
                teamSvc.removeMeber(memberId);
            }catch (TeamException e){
                System.out.println(e.getMessage());
            }
            TSUtility.readReturn();
        }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
