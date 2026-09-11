# Velho Steve

Projeto Java desenvolvido como atividade de Programação Orientada a Objetos (POO), com foco em refatoração, herança, encapsulamento, polimorfismo e uso de interfaces.

O sistema simula uma pequena fábrica de picaretas. É possível fabricar ferramentas de diferentes materiais, minerar blocos usando uma picareta e reparar sua durabilidade.

## Objetivo da atividade

Praticar os seguintes conceitos de POO:

- Herança entre classes;
- Encapsulamento de atributos por meio de métodos acessores;
- Polimorfismo por meio da implementação de uma interface;
- Separação entre entidade e serviço;
- Uso de `enum` para representar materiais e seus atributos;
- Manipulação de listas de objetos;
- Refatoração e organização de responsabilidades.

## Estrutura do projeto

```text
velhoStreveRefactor/
├── src/
│   ├── Main.java
│   ├── classes/
│   │   ├── entidades/
│   │   │   ├── FerramentaAbstrata.java
│   │   │   └── PicaretaEntidade.java
│   │   └── services/
│   │       └── PicaretaServico.java
│   ├── enums/
│   │   └── Materiais.java
│   └── interfaces/
│       └── Ferramenta.java
├── velhoStreveRefactor.iml
├── README.md
└── out/ (gerado após a compilação)
```

## Como funciona

Ao iniciar, a aplicação:

1. Cria picaretas de madeira, pedra, ferro e ouro;
2. Armazena as picaretas fabricadas em uma lista;
3. Exibe as ferramentas criadas;
4. Seleciona a picareta de ouro para minerar;
5. Atualiza sua durabilidade conforme os blocos minerados;
6. Repara a picareta, respeitando o limite máximo de durabilidade do material;
7. Exibe o estado final de todas as picaretas.

Os materiais disponíveis e seus atributos são:

| Material | Durabilidade | Força |
| --- | ---: | ---: |
| Madeira | 50 | 5 |
| Pedra | 70 | 8 |
| Ferro | 100 | 12 |
| Ouro | 31 | 9 |

## Classes e componentes principais

- `FerramentaAbstrata` — concentra os atributos comuns de uma ferramenta, como nome, durabilidade, material e força.
- `PicaretaEntidade` — representa uma picareta e mantém a lista das picaretas fabricadas.
- `PicaretaServico` — implementa as operações de fabricar, minerar e reparar picaretas.
- `Ferramenta` — interface que define as operações disponíveis para uma ferramenta.
- `Materiais` — enum que define os materiais, sua durabilidade e força.
- `Main` — classe responsável por executar o fluxo principal da aplicação.

## Observações

Este projeto é uma implementação didática de uma fábrica de picaretas, voltada ao estudo de orientação a objetos em Java. A interface `Ferramenta` define o contrato das operações, enquanto `PicaretaServico` concentra as regras de negócio e as classes de entidade representam os objetos manipulados pelo sistema.

## Autor

Atividade desenvolvida para estudo de Java e Programação Orientada a Objetos.
