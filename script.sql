-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS assistencia;

-- Uso do banco de dados criado
USE assistencia;

-- Criação da tabela aparelho
CREATE TABLE IF NOT EXISTS aparelho (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Chave primária
    nome VARCHAR(255) NOT NULL,           -- Nome do aparelho
    marca VARCHAR(255) NOT NULL,          -- Marca do aparelho
    tipo VARCHAR(255) NOT NULL,           -- Tipo do aparelho (ex.: ferro, aspirador)
    ano INT NOT NULL                      -- Ano de fabricação
);

-- Criação da tabela ordem_de_servico
CREATE TABLE IF NOT EXISTS ordem_de_servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- Chave primária
    data DATE NOT NULL,                     -- Data da ordem de serviço
    aparelho_id BIGINT NOT NULL,            -- Aparelho relacionado (chave estrangeira)
    descricao_problema TEXT NOT NULL,       -- Descrição do problema
    tipo_servico VARCHAR(255) NOT NULL,     -- Tipo de serviço (ex.: reparo, troca)
    status VARCHAR(50) DEFAULT 'Em andamento', -- Status padrão
    FOREIGN KEY (aparelho_id) REFERENCES aparelho(id) ON DELETE CASCADE -- Chave estrangeira
);
