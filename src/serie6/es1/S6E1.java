package assignment06.assignments.es1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment06.assignments.es1.person.Person;
import assignment06.assignments.es1.person.PersonFactory;
import assignment06.assignments.es1.person.Worker;
import assignment06.assignments.es1.person.Student;

public class S6E1 {

	private interface CategorizeOperation<K> {
		
		K getCategory(Person p);
	}
	
	private interface EvaluateOperation {

		boolean evaluate(Person p);
	}
	
	public static void main(String[] args) {
		List<Person> population = init(100);

		// Categorize population by surname
		final CategorizeOperation<String> categorizeBySurnameOperation = new CategorizeOperation<String>() {

			@Override
			public String getCategory(Person p) {
				return p.getSurname();
			}
		};
		Map<String, List<Person>> categorizedBySurname = new HashMap<>();
		for (Person person : population) {
			String category = categorizeBySurnameOperation.getCategory(person);
			if (categorizedBySurname.containsKey(category) == false)
				categorizedBySurname.put(category, new ArrayList<>());
			categorizedBySurname.get(category).add(person);
		}
		
		// Categorize population by Occupation
		final CategorizeOperation<String> categorizeByOccupationOperation = new CategorizeOperation<String>() {

			@Override
			public String getCategory(Person p) {
				if (p instanceof Student)
					return ((Student) p).getEducationalStage().toString();
				if (p instanceof Worker)
					return ((Worker) p).getWorkSector().toString();
				return "RETIRED";
			}
		};
		Map<String, List<Person>> categorizedByOccupation = new HashMap<>();
		for (Person person : population) {
			String category = categorizeByOccupationOperation.getCategory(person);
			if (categorizedByOccupation.containsKey(category) == false)
				categorizedByOccupation.put(category, new ArrayList<>());
			categorizedByOccupation.get(category).add(person);
		}

		// Categorize population by Age (in decades)
		final CategorizeOperation<Integer> categorizeByAgeOperation = new CategorizeOperation<Integer>() {
			@Override
			public Integer getCategory(Person p) {
				return p.getAge() / 10;
			}
		};
		Map<Integer, List<Person>> categorizedByAgeDecades = new HashMap<>();
		for (Person person : population) {
			Integer category = categorizeByAgeOperation.getCategory(person);
			if (categorizedByAgeDecades.containsKey(category) == false)
				categorizedByAgeDecades.put(category, new ArrayList<>());
			categorizedByAgeDecades.get(category).add(person);
		}

		// Search for people working in secondary sector having salary between 50k - 80k 
		final EvaluateOperation evaluateSecondarySalary50k_80kOperation = new EvaluateOperation() {

			@Override
			public boolean evaluate(Person p) {
				if (!(p instanceof Worker))
					return false;
				final Worker worker = (Worker) p;
				return worker.getWorkSector() == Worker.WorkSectorType.SECONDARY && 
						worker.getSalary() >= 50_000 && 
						worker.getSalary() <= 80_000;
			}
		};
		List<Person> secondaryWorkers = new ArrayList<>();
		for (Person person : population) {
			if (evaluateSecondarySalary50k_80kOperation.evaluate(person))
				secondaryWorkers.add(person);
		}

		// Search for high school students
		final EvaluateOperation evaluateHighSchoolStudentOperation = new EvaluateOperation() {
			@Override
			public boolean evaluate(Person p) {
				return p instanceof Student &&
						((Student) p).getEducationalStage() == Student.EducationalStage.HIGH_SCHOOL;
			}
		};
		List<Person> highSchoolStudents = new ArrayList<>();
		for (Person person : population) {
			if (evaluateHighSchoolStudentOperation.evaluate(person))
				highSchoolStudents.add(person);
		}


		// Print results
		printCategorizedString("Population by surname", categorizedBySurname);
		printCategorizedString("Population by occupation", categorizedByOccupation);
		printCategorizedInteger("Population by decades", categorizedByAgeDecades);
		printPersonList("HighSchool students", highSchoolStudents);
		printPersonList("Secondary sector workers with salary (50k - 80k)", secondaryWorkers);
	}

	// Utility methods
	
	// Generate random dataset
	private static List<Person> init(int populationSize) {
		// Generate random dataset
		List<Person> population = new ArrayList<>();
		for (int i = 0; i < populationSize; i++)
			population.add(PersonFactory.createRandomPerson());
		
		// Print all persons
		for (Person p : population)
			System.out.println(p);

		return population;
	}
	
	private static void printCategorizedString(String title, Map<String, List<Person>> categorized) {
		System.out.println("----------------------------------");
		System.out.println(title);
		System.out.println("----------------------------------");
		for (String surname : categorized.keySet())
			System.out.println(String.format("%s : %d", surname, categorized.get(surname).size()));
	}
	
	private static void printCategorizedInteger(String title, Map<Integer, List<Person>> categorized) {
		System.out.println("----------------------------------");
		System.out.println(title);
		System.out.println("----------------------------------");
		for (Integer category : categorized.keySet())
			System.out.println(String.format("%d : %d", category, categorized.get(category).size()));
	}
	
	private static void printPersonList(String title, List<Person> people) {
		System.out.println("----------------------------------");
		System.out.println(String.format("%s [%d]", title, people.size()));
		System.out.println("----------------------------------");
		for (Person p : people)
			System.out.print(p + ", ");
		System.out.println();
	}
}
