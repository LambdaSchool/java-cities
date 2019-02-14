package com.lambdaschool.rabbitscities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<City, Long>
{

}
