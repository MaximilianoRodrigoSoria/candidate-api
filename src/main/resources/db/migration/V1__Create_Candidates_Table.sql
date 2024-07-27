
CREATE TABLE candidates (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL,
                            gender VARCHAR(10),
                            expected_salary DECIMAL(10, 2),
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            active BOOLEAN DEFAULT TRUE,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            type_of_contract VARCHAR(50)
);

INSERT INTO candidates (name, email, gender, expected_salary, active, updated_at, type_of_contract) VALUES
                                                                                                        ('John Doe', 'john.doe@example.com', 'Male', 60000, TRUE, CURRENT_TIMESTAMP, 'Full-time'),
                                                                                                        ('Jane Smith', 'jane.smith@example.com', 'Female', 65000, TRUE, CURRENT_TIMESTAMP, 'Part-time'),
                                                                                                        ('Alice Johnson', 'alice.johnson@example.com', 'Female', 70000, TRUE, CURRENT_TIMESTAMP, 'Contractor'),
                                                                                                        ('Bob Brown', 'bob.brown@example.com', 'Male', 55000, TRUE, CURRENT_TIMESTAMP, 'Intern'),
                                                                                                        ('Charlie Black', 'charlie.black@example.com', 'Male', 60000, TRUE, CURRENT_TIMESTAMP, 'Freelance');
