-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 22-Out-2018 às 22:58
-- Versão do servidor: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banco_ovg`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `composicao_familiar`
--

CREATE TABLE `composicao_familiar` (
  `id` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `parentesco` varchar(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `data_nasc` date DEFAULT NULL,
  `profissao` varchar(20) DEFAULT NULL,
  `renda` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `depesas_familiares`
--

CREATE TABLE `depesas_familiares` (
  `id` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `moradia` double DEFAULT NULL,
  `energia` double DEFAULT NULL,
  `agua` double DEFAULT NULL,
  `alimentacao` double DEFAULT NULL,
  `farmacia` double DEFAULT NULL,
  `gas` double DEFAULT NULL,
  `telefone` double DEFAULT NULL,
  `financiamento` double DEFAULT NULL,
  `outros` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `logadouro` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `cep` varchar(8) NOT NULL,
  `id_municipio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `cod_est` int(11) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `uf` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens_processo`
--

CREATE TABLE `itens_processo` (
  `id` int(11) NOT NULL,
  `id_pedidio` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `entregue` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `municipio`
--

CREATE TABLE `municipio` (
  `id` int(11) NOT NULL,
  `cod_ibge` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `id_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `processo`
--

CREATE TABLE `processo` (
  `id_processo` int(11) NOT NULL,
  `data_processo` date NOT NULL,
  `data_envio` date DEFAULT NULL,
  `data_entrega_prev_ovg` date DEFAULT NULL,
  `data_entrega_sec` date DEFAULT NULL,
  `status_pedido` char(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `data_prox_pedido` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `quantidade` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitante`
--

CREATE TABLE `solicitante` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `rg` varchar(7) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `nome_pai` varchar(100) DEFAULT NULL,
  `nome_mae` varchar(100) DEFAULT NULL,
  `id_endereco` int(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  `naturalidade` varchar(20) DEFAULT NULL,
  `estado_civil` varchar(20) DEFAULT NULL,
  `historico_social` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE `telefone` (
  `id` int(11) NOT NULL,
  `id_solicitante` int(11) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `tipo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `composicao_familiar`
--
ALTER TABLE `composicao_familiar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_composicao_familiar_solicitante2_idx` (`id_solicitante`);

--
-- Indexes for table `depesas_familiares`
--
ALTER TABLE `depesas_familiares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_depesas_familiares_solicitante1_idx` (`id_solicitante`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_endereco_municipio1_idx` (`id_municipio`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `itens_processo`
--
ALTER TABLE `itens_processo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_itens_pedido_pedido1_idx` (`id_pedidio`),
  ADD KEY `fk_itens_pedido_produto1_idx` (`id_produto`);

--
-- Indexes for table `municipio`
--
ALTER TABLE `municipio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_municipio_estado1_idx` (`id_estado`);

--
-- Indexes for table `processo`
--
ALTER TABLE `processo`
  ADD PRIMARY KEY (`id_processo`),
  ADD KEY `fk_pedido_usuario_idx` (`id_usuario`),
  ADD KEY `fk_pedido_solicitante1_idx` (`id_solicitante`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `solicitante`
--
ALTER TABLE `solicitante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_solicitante_endereco1_idx` (`id_endereco`);

--
-- Indexes for table `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_telefone_solicitante1_idx1` (`id_solicitante`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `itens_processo`
--
ALTER TABLE `itens_processo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `municipio`
--
ALTER TABLE `municipio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `processo`
--
ALTER TABLE `processo`
  MODIFY `id_processo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `solicitante`
--
ALTER TABLE `solicitante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `composicao_familiar`
--
ALTER TABLE `composicao_familiar`
  ADD CONSTRAINT `fk_composicao_familiar_solicitante2` FOREIGN KEY (`id_solicitante`) REFERENCES `solicitante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `depesas_familiares`
--
ALTER TABLE `depesas_familiares`
  ADD CONSTRAINT `fk_depesas_familiares_solicitante1` FOREIGN KEY (`id_solicitante`) REFERENCES `solicitante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_endereco_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `itens_processo`
--
ALTER TABLE `itens_processo`
  ADD CONSTRAINT `fk_itens_pedido_pedido1` FOREIGN KEY (`id_pedidio`) REFERENCES `processo` (`id_processo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itens_pedido_produto1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `municipio`
--
ALTER TABLE `municipio`
  ADD CONSTRAINT `fk_municipio_estado1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `processo`
--
ALTER TABLE `processo`
  ADD CONSTRAINT `fk_pedido_solicitante1` FOREIGN KEY (`id_solicitante`) REFERENCES `solicitante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `solicitante`
--
ALTER TABLE `solicitante`
  ADD CONSTRAINT `fk_solicitante_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `fk_telefone_solicitante1` FOREIGN KEY (`id_solicitante`) REFERENCES `solicitante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
