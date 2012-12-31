--create database infos;

drop table if exists empleado cascade;

drop table if exists menu_rol cascade;
drop table if exists menu cascade;

drop table if exists usuario cascade;
drop table if exists compania cascade;
drop table if exists rol cascade;

-- ============================================================================================================

create table compania
        (
        id integer not null,
        nombre character varying(100),
        constraint compania_pk0 primary key (id)
        );

create table rol
        (
        id character varying(50) not null,
        descripcion character varying(500),
        constraint rol_pk0 primary key (id)
        );

create table usuario
        (
        id character varying(50) not null,
        descripcion character varying(500),
        fecha_fin timestamp without time zone,
        fecha_inicio timestamp without time zone,
        compania integer not null,
        rol character varying(50) not null,
        constraint usuario_pk0 primary key (id),
        constraint usuario_fk1 foreign key (compania) references compania (id),
        constraint usuario_fk2 foreign key (rol) references rol (id)
    );

create table menu
    (
        id integer not null,
        titulo character varying(500),
        direccion character varying(1000),
        icono character varying(500),
        menu_padre integer,
        constraint menu_pk0 primary key (id),
        constraint menu_fk1 foreign key (menu_padre) references menu (id)
    );

create table menu_rol
        (
        menu integer not null,
        rol character varying(50) not null,
        primary key (menu, rol),
        constraint menu_rol_fk1 foreign key (menu) references menu (id),
        constraint menu_rol_fk2 foreign key (rol) references rol (id)
        );

create table empleado
        (
        id character varying(50) not null,
        primer_nombre character varying(100) not null,
        segundo_nombre character varying(100),
        primer_apellido character varying(100) not null,
        segundo_apellido character varying(100),
        apellido_casada character varying(100),
        apartado_email character varying(500),
        --cod_pais integer,
        --cod_puesto varchar2(255),
        direccion character varying(1000),
        estado integer not null,
        estado_civil integer not null,
        fecha_ingreso timestamp without time zone not null,
        --identificacion varchar2(255),
        sexo integer not null,
        telefono character varying(255),
        tipo_sangre character varying(255),
        celular character varying(255),
        email character varying(255),
        externo boolean not null,
        jefe character varying(50),
        constraint empleados_pk0 primary key (id),
        constraint empleados_fk1 foreign key (id) references usuario (id),
        constraint empleados_fk2 foreign key (jefe) references empleado (id)
    );
-- ============================================================================================================

insert into compania (id, nombre) values (1, 'infosgroup el salvador');

insert into rol (id, descripcion) values ('gerente', null);
insert into rol (id, descripcion) values ('formalizador', null);
insert into rol (id, descripcion) values ('vendedor', null);
insert into rol (id, descripcion) values ('brocker', null);

insert into usuario (id, compania, rol) values ('jguerrero', 1, 'gerente');
insert into usuario (id, compania, rol) values ('dmendivil', 1, 'gerente');

insert into menu (id, titulo) values (1000, 'Administración');
insert into menu (id, titulo, menu_padre) values (1100, 'Catálogos', 1000);
insert into menu (id, titulo) values (2000, 'Prospectación');
insert into menu (id, titulo) values (3000, 'Formalización');
insert into menu (id, titulo) values (4000, 'Ayuda');
insert into menu (id, titulo, menu_padre) values (4100, 'Ayuda', 4000);
insert into menu (id, titulo, menu_padre) values (4200, 'Acerca de...', 4000);

insert into menu_rol (menu, rol) values (1000, 'gerente');
insert into menu_rol (menu, rol) values (1100, 'gerente');
insert into menu_rol (menu, rol) values (2000, 'gerente');
insert into menu_rol (menu, rol) values (3000, 'gerente');
insert into menu_rol (menu, rol) values (4000, 'gerente');
insert into menu_rol (menu, rol) values (4100, 'gerente');
insert into menu_rol (menu, rol) values (4200, 'gerente');