-- Tabela para armazenar informações de usuários (alunos e professores)
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL -- Pode ser 'aluno' ou 'professor'
);

-- Tabela para armazenar informações específicas de alunos
CREATE TABLE alunos (
    id_usuario SERIAL PRIMARY KEY,
    matricula VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela para armazenar informações específicas de professores
CREATE TABLE professores (
    id_usuario SERIAL PRIMARY KEY,
    departamento VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela para armazenar informações sobre cursos
CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL, -- Pode ser 'Aberto', 'Fechado', etc.
    capacidade INTEGER NOT NULL
);

-- Tabela para associar alunos a cursos (relacionamento muitos para muitos)
CREATE TABLE alunos_cursos (
    id_aluno SERIAL,
    id_curso SERIAL,
    PRIMARY KEY (id_aluno, id_curso),
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_usuario),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);

-- Tabela para associar professores a cursos (relacionamento muitos para muitos)
CREATE TABLE professores_cursos (
    id_professor SERIAL,
    id_curso SERIAL,
    PRIMARY KEY (id_professor, id_curso),
    FOREIGN KEY (id_professor) REFERENCES professores(id_usuario),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);
