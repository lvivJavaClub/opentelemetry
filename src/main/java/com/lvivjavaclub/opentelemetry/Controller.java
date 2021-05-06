/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lvivjavaclub.opentelemetry;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final PersonRepository personRepository;
    private final PersonService personService = new PersonService();

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    @PostMapping("/person")
    public Long createPerson(@RequestBody Person person) {
        return personRepository.save(person).getId();
    }

    @GetMapping("/person")
    public Person generatePerson() {
        return personRepository.save(personService.generatePerson());
    }
}
