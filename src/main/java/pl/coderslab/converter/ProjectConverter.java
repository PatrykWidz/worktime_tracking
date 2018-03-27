package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Project;
import pl.coderslab.repository.ProjectRepository;

public class ProjectConverter implements Converter<String, Project> {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public Project convert(String id) {
		
		Project project = projectRepo.findById(Long.parseLong(id)).get();
		
		return project;
	}

}
