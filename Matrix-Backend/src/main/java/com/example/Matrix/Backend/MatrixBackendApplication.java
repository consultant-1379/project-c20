package com.example.Matrix.Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Matrix.Backend.QuestionTypes.LowLevelQuestion;
import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;
import com.example.Matrix.Backend.QuestionTypes.TopLevelQuestion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class MatrixBackendApplication {
	//Get all the String values for each Row
	@Value("${arrayOfStrings1}")
	private List<String> rowStrings1;

	@Value("${arrayOfStrings2}")
	private List<String> rowStrings2;

	@Value("${arrayOfStrings3}")
	private List<String> rowStrings3;

	@Value("${arrayOfStrings4}")
	private List<String> rowStrings4;

	@Value("${arrayOfStrings5}")
	private List<String> rowStrings5;

	@Value("${arrayOfStrings6}")
	private List<String> rowStrings6;

	@Value("${arrayOfStrings7}")
	private List<String> rowStrings7;

	@Value("${arrayOfStrings8}")
	private List<String> rowStrings8;

	@Value("${arrayOfStrings9}")
	private List<String> rowStrings9;

	/*------------------------------------------------------------*/

	//Get All the Stage Values
	@Value("${listOfStages}")
	private List<String> stages;

	public static void main(String[] args) {
		SpringApplication.run(MatrixBackendApplication.class, args);
	}

	//Bean of the Row String HashMap
	//Contains the Values of the String at each point on a row
	@ApplicationScope
	@Bean
	public Map<Integer, List<String>> getRowStringHashMap() {
		Map<Integer, List<String>> stringRowHashMap = new HashMap<>();

		//Adds the Strings to each Row with a Row ID (Integer)
		stringRowHashMap.put(1,rowStrings1);
		stringRowHashMap.put(2,rowStrings2);
		stringRowHashMap.put(3,rowStrings3);
		stringRowHashMap.put(4,rowStrings4);
		stringRowHashMap.put(5,rowStrings5);
		stringRowHashMap.put(6,rowStrings6);
		stringRowHashMap.put(7,rowStrings7);
		stringRowHashMap.put(8,rowStrings8);
		stringRowHashMap.put(9,rowStrings9);

		//Returns the String Row HashMap 
		return stringRowHashMap;
	}

	@ApplicationScope
	@Bean
	public Map<Integer, String> getStageHashMap(){
		Map<Integer,String> stringStageHashMap = new HashMap<>();

		//Add in Stages for Each Row
		for(int i = 0; i<stages.size(); i++){
			stringStageHashMap.put(i+1, stages.get(i));
		}

		//Returns the HashMap
		return stringStageHashMap;
	}

	@ApplicationScope
	@Bean
    public Map<Integer, TopLevelQuestion> topLevelQuestions() {
        Map<Integer, TopLevelQuestion> topLevelQuestions = new HashMap<>();
        QuestionAnswerItem qItem1 = new QuestionAnswerItem(1, true, "Do you have a collaborative culture (e.g. big but not specific/highly detailed goals with no fixed delivery dates)?");
		topLevelQuestions.put(1, new TopLevelQuestion(1, qItem1));

        QuestionAnswerItem qItem2 = new QuestionAnswerItem(2, true, "Is your product and design data driven – that is they are rapidly prototyped, deployed and evaluated based on real customer usage before deciding on further development or retirement)");
        topLevelQuestions.put(2, new TopLevelQuestion(1, qItem2));

        QuestionAnswerItem qItem3 = new QuestionAnswerItem(3, true, "Are teams Devops teams that is self contained teams responsible for all development and deployment to production and production is monitored by SRE teams?");
        topLevelQuestions.put(3, new TopLevelQuestion(1, qItem3));

        QuestionAnswerItem qItem4 = new QuestionAnswerItem(4, true, "Do you use research and experimentation techniques for large and complex problems- using lots of proof of concepts to compare options, using Kanban to clarify the project then Agile methods like Scrum once problem is well understood?");
        topLevelQuestions.put(4, new TopLevelQuestion(1, qItem4));

        QuestionAnswerItem qItem5 = new QuestionAnswerItem(5, true, "Do you have a microprocessor architecture built from independently deployable services?");
        topLevelQuestions.put(5, new TopLevelQuestion(1, qItem5));

        QuestionAnswerItem qItem6 = new QuestionAnswerItem(6, true, "Does your system collect metrics, alerts tracing and logging to provide a view of the running system and try to keep itself alive through seldf healing if things begin to deteriorate?");
        topLevelQuestions.put(6, new TopLevelQuestion(1, qItem6));

        QuestionAnswerItem qItem7 = new QuestionAnswerItem(7, true, "Do you deliver multiple times a day your releasable software?");
        topLevelQuestions.put(7, new TopLevelQuestion(1, qItem7));

        QuestionAnswerItem qItem8 = new QuestionAnswerItem(8, true, "Do you run on Kubernetes?");
        topLevelQuestions.put(8, new TopLevelQuestion(1, qItem8));

        QuestionAnswerItem qItem9 = new QuestionAnswerItem(9, true, "Do you deploy your software in containers?");
        topLevelQuestions.put(9, new TopLevelQuestion(1, qItem9));

        return topLevelQuestions;
	}

	@ApplicationScope
	@Bean
	public Map<Integer, LowLevelQuestion> lowLevelQuestions() {
        Map<Integer, LowLevelQuestion> lowLevelQuestions = new HashMap<>();

        List<QuestionAnswerItem> qItems1 = new ArrayList<>();
        qItems1.add(new QuestionAnswerItem(1, false, "Project managers coordinate between all the different teams working on the same project, and the teams have highly specialised responsibilities."));
        qItems1.add(new QuestionAnswerItem(2, false, "Our development teams focus on achieving small, defined objectives quickly and then moving immediately to the next one."));
        qItems1.add(new QuestionAnswerItem(3, false, "A lot of up-front planning goes into documenting each step of a project before it even begins."));
        qItems1.add(new QuestionAnswerItem(4, false, "Each team contain a mix of members whose different areas of expertise cover the full spectrum of skills needed for crafting a releasable increment."));

        lowLevelQuestions.put(1, new LowLevelQuestion(1, qItems1));

        List<QuestionAnswerItem> qItems2 = new ArrayList<>();
        qItems2.add(new QuestionAnswerItem(1, false, "We have product roadmaps spanning months or even years into the future. Our releases typically happen every six months to one year, sometimes even longer."));
        qItems2.add(new QuestionAnswerItem(2, false, "There is pressure to deliver features, fast, and releases happen on a regular planned basis. (For example, ‘We’ll Feature X in two months, Feature Y in four months and Feature Z in six months’—with no deviation from the schedule)."));
        qItems2.add(new QuestionAnswerItem(3, false, "We release large sets of related features all at once as comprehensive updates."));
        qItems2.add(new QuestionAnswerItem(4, false, "Our releases are usually small-scale iterative changes to existing features/services."));

        lowLevelQuestions.put(2, new LowLevelQuestion(2, qItems2));

        List<QuestionAnswerItem> qItems3 = new ArrayList<>();
        qItems3.add(new QuestionAnswerItem(1, false, "All decisions are made by managers, and teams must seek permission before changing any part of the project plan, no matter how small."));
        qItems3.add(new QuestionAnswerItem(2, false, "Applications are developed as several large components, with one team per component fully and vertically responsible for the build."));
        qItems3.add(new QuestionAnswerItem(3, false, "We have separate teams of specialists to handle different areas: design, architecture, security, testing, etc. When our team’s piece of a project is finished, we hand it off to the next team."));
        qItems3.add(new QuestionAnswerItem(4, false, "Our teams are mixed: We have developers, QA/testing, someone with server experience, etc. all in one group. We don’t talk to other teams very much since our teams are meant to be self-sufficient and independent."));

        lowLevelQuestions.put(3, new LowLevelQuestion(3, qItems3));

        List<QuestionAnswerItem> qItems4 = new ArrayList<>();
        qItems4.add(new QuestionAnswerItem(1, false, "We do all our planning up front, and then hand off to teams for execution. Managers handle the collaboration and communication between our teams"));
        qItems4.add(new QuestionAnswerItem(2, false, "A team will work on one small, defined project and deliver it in two to four weeks. If a new feature request comes in the middle of a delivery cycle, we may or may not be able to add it in."));
        qItems4.add(new QuestionAnswerItem(3, false, "If a new feature request comes in the middle of a delivery cycle, we have to wait for the next cycle to plan for and incorporate it."));
        qItems4.add(new QuestionAnswerItem(4, false, "If we can’t coordinate or fix an issue on the last day or two of a production cycle, we can’t ship—so when a bug or some other problem pops up it’s hard to do anything more than a quick fix. (Following up to address an issue in more depth requires a dedicated sprint so we can focus on it)."));

        lowLevelQuestions.put(4, new LowLevelQuestion(4, qItems4));

        List<QuestionAnswerItem> qItems5 = new ArrayList<>();
        qItems5.add(new QuestionAnswerItem(1, false, "Our system is very big. Few people understand the whole thing. We fear the domino effect: If you change something, you have to be very careful because it could break something else."));
        qItems5.add(new QuestionAnswerItem(2, false, "Our application(s) is(are) divided into components, probably no more than five or six, communicating through networking."));
        qItems5.add(new QuestionAnswerItem(3, false, "When we deliver, everything is delivered together, all ready on the same day and at a uniformly high level of quality."));
        qItems5.add(new QuestionAnswerItem(4, false, "The scope of an app in development is defined by the deployment schedule. Each feature or piece of functionality is broken down into deliverable chunks that fit into the schedule."));

        lowLevelQuestions.put(5, new LowLevelQuestion(5, qItems5));

        List<QuestionAnswerItem> qItems6 = new ArrayList<>();
        qItems6.add(new QuestionAnswerItem(1, false, "We have some simple automation, like scripts, for alerting large-scale issues and outages in the field. We find out about many smaller problems from user reports."));
        qItems6.add(new QuestionAnswerItem(2, false, "Our systems have full and continuous monitoring, and our Ops team spends lots of time checking on alerts. A lot of time, our system alerts turn out to be nothing."));
        qItems6.add(new QuestionAnswerItem(3, false, "When problems arise, we have to open each server to understand what happened because we don’t have central logs or tracing. Then we fix it manually: someone from Operations logs into a production server and follows a preset procedure"));
        qItems6.add(new QuestionAnswerItem(4, false, "Some of our system update processes are fully automated and patches can be applied quickly—but a human still has to initialise the process."));

        lowLevelQuestions.put(6, new LowLevelQuestion(6, qItems6));

        List<QuestionAnswerItem> qItems7 = new ArrayList<>();
        qItems7.add(new QuestionAnswerItem(1, false, "We do ‘big bang’ releases that roll lots of changes into one new version, every six to 12 months. A lot of up-front planning goes into our next release before any actual development begins."));
        qItems7.add(new QuestionAnswerItem(2, false, "Our delivery process includes some test automation and automated build, but outside of final integration. In an emergency, we can make manual updates to the production codebase"));
        qItems7.add(new QuestionAnswerItem(3, false, "We don’t like to make changes to our production code, even emergency ones, because there are so many dependencies. Change is risky. Once we release a software version all changes have to wait for the next version roll out."));
        qItems7.add(new QuestionAnswerItem(4, false, "New functionality requests typically can be accommodated within a few weeks, if they are urgent."));

        lowLevelQuestions.put(7, new LowLevelQuestion(7, qItems7));

        List<QuestionAnswerItem> qItems8 = new ArrayList<>();
        qItems8.add(new QuestionAnswerItem(1, false, "Operations team is in charge of provisioning, period. You have to write a ticket to provision a machine—engineers can’t self-service."));
        qItems8.add(new QuestionAnswerItem(2, false, "A machine can be provisioned (possibly even autoprovisioned) in hours, or maybe a day or two, and the process is fully automated by Ops."));
        qItems8.add(new QuestionAnswerItem(3, false, "Developers write applications, and specify what they will need to run successfully in production (OS, libraries, dependent tools). The Ops team manually configures the production machines to meet the machine dependencies the Dev team specified."));
        qItems8.add(new QuestionAnswerItem(4, false, "Provisioning is a mix of automation and manual work. Any task taking longer than a week to provision to VM breaks the production cycle, so is a nonstarter."));

        lowLevelQuestions.put(8, new LowLevelQuestion(8, qItems8));

        List<QuestionAnswerItem> qItems9 = new ArrayList<>();
        qItems9.add(new QuestionAnswerItem(1, false, "We have multiple physical servers in our own private data center (either on premises or co-located). If one of our servers goes down, we have to manually provision its replacement."));
        qItems9.add(new QuestionAnswerItem(2, false, "We don’t use physical servers—we have VMs. We also have some instances in the cloud, which we manage manually."));
        qItems9.add(new QuestionAnswerItem(3, false, "A data centre failure is just about the worst disaster we can imagine."));
        qItems9.add(new QuestionAnswerItem(4, false, "Provisioning infrastructure is a mix of automation and manual work, so a new VM can take a couple of days to set up."));

        lowLevelQuestions.put(9, new LowLevelQuestion(9, qItems9));

        return lowLevelQuestions;
    }

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}