
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL 
);


CREATE TABLE alunos (
    id_usuario SERIAL PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


CREATE TABLE professores (
    id_usuario SERIAL PRIMARY KEY,
    departamento VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL, .
    capacidade INTEGER NOT NULL
);


CREATE TABLE alunos_cursos (
    id_aluno SERIAL,
    id_curso SERIAL,
    PRIMARY KEY (id_aluno, id_curso),
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_usuario),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);


CREATE TABLE professores_cursos (
    id_professor SERIAL,
    id_curso SERIAL,
    PRIMARY KEY (id_professor, id_curso),
    FOREIGN KEY (id_professor) REFERENCES professores(id_usuario),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);
