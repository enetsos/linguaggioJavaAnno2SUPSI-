package midTest.es2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Skill {
    enum Type { PROGRAMMING, MANAGEMENT }

    private final Skill.Type type;
    private final String name;
    private int years;

    public Skill(Skill.Type type, String name, int years) {
        this.type = type;
        this.name = name;
        this.years = years;
    }

    public Skill.Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }

    public void incrementYears() {
        years++;
    }

    @Override
    public String toString() {
        return String.format("%s %d years", name, years);
    }
}

class Developer {
    private final String name;
    private String team;
    private final List<Skill> skillList = new ArrayList<>();

    public Developer(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public void addSkill(Skill.Type type, final String language, int years) {
        skillList.add(new Skill(type, language, years));
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    @Override
    public String toString() {
        return name + " ("+ team + ") - " + skillList;
    }
}

public class StreamExercise {
    public static void main(String[] args) {
        final List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("Mike", "Product 1"));
        developers.get(0).addSkill(Skill.Type.MANAGEMENT, "Scrum", 10);
        developers.get(0).addSkill(Skill.Type.MANAGEMENT, "Kanban", 8);
        developers.get(0).addSkill(Skill.Type.PROGRAMMING, "C", 16);
        developers.get(0).addSkill(Skill.Type.PROGRAMMING, "C++", 14);

        developers.add(new Developer("Steve", "Product 1"));
        developers.get(1).addSkill(Skill.Type.PROGRAMMING,"C", 3);
        developers.get(1).addSkill(Skill.Type.PROGRAMMING,"C++", 1);

        developers.add(new Developer("Anna", "Product 1"));
        developers.get(2).addSkill(Skill.Type.PROGRAMMING,"C", 1);
        developers.get(2).addSkill(Skill.Type.PROGRAMMING,"C++", 4);
        developers.get(2).addSkill(Skill.Type.PROGRAMMING,"C#", 3);

        developers.add(new Developer("Frida", "Product 2"));
        developers.get(3).addSkill(Skill.Type.MANAGEMENT, "Scrum", 3);
        developers.get(3).addSkill(Skill.Type.MANAGEMENT, "Kanban", 2);
        developers.get(3).addSkill(Skill.Type.PROGRAMMING,"JavaScript", 4);
        developers.get(3).addSkill(Skill.Type.PROGRAMMING,"TypeScript", 2);

        developers.add(new Developer("Carl", "Product 2"));
        developers.get(4).addSkill(Skill.Type.PROGRAMMING,"Python", 3);
        developers.get(4).addSkill(Skill.Type.PROGRAMMING,"C", 4);
        developers.get(4).addSkill(Skill.Type.PROGRAMMING,"TypeScript", 1);
        developers.get(4).addSkill(Skill.Type.PROGRAMMING,"C#", 2);

        developers.add(new Developer("Helen", "Product 2"));
        developers.get(5).addSkill(Skill.Type.PROGRAMMING,"Java", 1);
        developers.get(5).addSkill(Skill.Type.PROGRAMMING,"JavaScript", 2);
        developers.get(5).addSkill(Skill.Type.PROGRAMMING,"C#", 1);
        developers.get(5).addSkill(Skill.Type.PROGRAMMING,"Go", 4);

        developers.add(new Developer("Bill", "Product 2"));
        developers.get(6).addSkill(Skill.Type.PROGRAMMING,"C#", 2);
        developers.get(6).addSkill(Skill.Type.PROGRAMMING,"JavaScript", 3);
        developers.get(6).addSkill(Skill.Type.PROGRAMMING,"TypeScript", 4);
        developers.get(6).addSkill(Skill.Type.PROGRAMMING,"Java", 3);

        developers.add(new Developer("Ada", "Product 3"));
        developers.get(7).addSkill(Skill.Type.PROGRAMMING,"Ruby", 4);

        developers.add(new Developer("John", "Product 4"));
        developers.get(8).addSkill(Skill.Type.MANAGEMENT,"Scrum", 13);

        developers.add(new Developer("Jane", "Product 4"));
        developers.get(9).addSkill(Skill.Type.PROGRAMMING,"Go", 3);
        developers.get(9).addSkill(Skill.Type.PROGRAMMING,"C#", 1);
        developers.get(9).addSkill(Skill.Type.PROGRAMMING,"JavaScript", 1);
        developers.get(9).addSkill(Skill.Type.PROGRAMMING,"Ruby", 4);

        System.out.printf("%nAll developers%n");
        developers.forEach(System.out::println);

        // Number of developers
        System.out.printf("%nNumber of developers%n");
        System.out.println(developers.stream().count());

        // Number of developers with management skills
        System.out.printf("%nNumber of developers with management skills%n");
        System.out.println(developers.stream().filter(developer -> {
            return developer.getSkillList().stream().anyMatch(skill -> skill.getType().equals(Skill.Type.MANAGEMENT));
        }).count());

        // Less skilled developer in 'Product 1' team
        System.out.printf("%nLess skilled developer in 'Product 1' team%n");
        System.out.println(developers.stream().filter(developer -> developer.getTeam().equals("Product 1")).min(Comparator.comparing(developer -> developer.getSkillList().stream().count())));

        // Developers by their Skill (sum of their Skill)
        System.out.printf("%ntop 5 skilled (sum of skills) by developer%n");
        developers.stream().sorted(Comparator.comparing(developer -> 1 - developer.getSkillList().stream().count())).limit(5).forEach(System.out::println);

        // Developers by their programming Skill years (sum of all years of their Skill)
        System.out.printf("%ntop 5 skilled (years) by developer%n");
        developers.stream().sorted(Comparator.comparing(developer -> 1 - developer.getSkillList().stream().count())).limit(5).forEach(System.out::println);

        // Team name, separated by comma. E.g: team1, team2, team3
        System.out.printf("%nTeam names%n");
        // FIXME to implement

        // Developer count by team
        System.out.printf("%nDeveloper count by team%n");
        // FIXME to implement

        // Largest team
        System.out.printf("%nLargest team%n");
        // FIXME to implement

        // All unique programming language
        System.out.printf("%nProgramming languages%n");
        // FIXME to implement

        // Developers count by skill
        System.out.printf("%nDevelopers count by Skill%n");
        // FIXME to implement

        // Update skill years
        System.out.printf("%nUpdating skill years (version 1)%n");
        // FIXME to implement

        // Update skill years - functional version
        System.out.printf("%nUpdating skill years (functional version)%n");
        // FIXME to implement
    }
}