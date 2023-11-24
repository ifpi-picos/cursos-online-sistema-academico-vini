CREATE TABLE alunos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);


CREATE TABLE professores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);


CREATE TABLE disciplinas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);


CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL, 
    max_alunos INTEGER NOT NULL
);


CREATE TABLE alunos_cursos (
    id SERIAL PRIMARY KEY,
    aluno_id INTEGER REFERENCES alunos(id),
    curso_id INTEGER REFERENCES cursos(id)
);


CREATE TABLE professores_disciplinas (
    id SERIAL PRIMARY KEY,
    professor_id INTEGER REFERENCES professores(id),
    disciplina_id INTEGER REFERENCES disciplinas(id)
);


CREATE TABLE notas (
    id SERIAL PRIMARY KEY,
    aluno_id INTEGER REFERENCES alunos(id),
    disciplina_id INTEGER REFERENCES disciplinas(id),
    nota INTEGER NOT NULL
);
