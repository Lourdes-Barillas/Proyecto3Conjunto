PGDMP     *    ;            	    x         
   Project3DB    13.0    13.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16400 
   Project3DB    DATABASE     i   CREATE DATABASE "Project3DB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE "Project3DB";
                postgres    false            �           0    0    DATABASE "Project3DB"    COMMENT     �   COMMENT ON DATABASE "Project3DB" IS 'La base de datos contendrá los productos, las ordenes, los clientes y otra necesidad con relaciones. Es compartida';
                   postgres    false    3028            �            1259    16401    Clientes    TABLE     �   CREATE TABLE public."Clientes" (
    "Cliente_Usuario" character varying(50) NOT NULL,
    "Cliente_Id" smallint NOT NULL,
    "Cliente_TipoCliente" character varying(50)
);
    DROP TABLE public."Clientes";
       public         heap    postgres    false            �            1259    16415    ClientesEmpresariales    TABLE     �   CREATE TABLE public."ClientesEmpresariales" (
    "CE_Id" smallint NOT NULL,
    "CE_Contacto" character varying NOT NULL,
    "CE_ClienteId" smallint NOT NULL
);
 +   DROP TABLE public."ClientesEmpresariales";
       public         heap    postgres    false            �            1259    16410    ClientesIndividuales    TABLE     �   CREATE TABLE public."ClientesIndividuales" (
    "CI_Id" smallint NOT NULL,
    "CI_DPI" bigint NOT NULL,
    "CI_ClienteId" smallint NOT NULL
);
 *   DROP TABLE public."ClientesIndividuales";
       public         heap    postgres    false            �            1259    16441    Item    TABLE     �   CREATE TABLE public."Item" (
    "Item_Id" smallint NOT NULL,
    "Item_Cantidad" smallint,
    "Item_ProductoId" smallint NOT NULL,
    "Item_Total" double precision,
    "Item_IdOrden" smallint NOT NULL
);
    DROP TABLE public."Item";
       public         heap    postgres    false            �           0    0    TABLE "Item"    COMMENT     5   COMMENT ON TABLE public."Item" IS 'Item de ordenes';
          public          postgres    false    204            �            1259    16461    Orden    TABLE       CREATE TABLE public."Orden" (
    "Orden_Id" smallint NOT NULL,
    "Orden_ClienteId" smallint NOT NULL,
    "Orden_Fecha" date,
    "Orden_PrecioDeEnvio" double precision,
    "Orden_TipoEnvio" character varying,
    "Orden_Estado" smallint NOT NULL,
    "Orden_DíasEnvio" smallint
);
    DROP TABLE public."Orden";
       public         heap    postgres    false            �            1259    16433 	   Productos    TABLE     �   CREATE TABLE public."Productos" (
    "Prod_Id" smallint NOT NULL,
    "Prod_Nombre" character varying,
    "Prod_Costo" double precision NOT NULL
);
    DROP TABLE public."Productos";
       public         heap    postgres    false            �          0    16401    Clientes 
   TABLE DATA           \   COPY public."Clientes" ("Cliente_Usuario", "Cliente_Id", "Cliente_TipoCliente") FROM stdin;
    public          postgres    false    200   �!       �          0    16415    ClientesEmpresariales 
   TABLE DATA           Y   COPY public."ClientesEmpresariales" ("CE_Id", "CE_Contacto", "CE_ClienteId") FROM stdin;
    public          postgres    false    202   �!       �          0    16410    ClientesIndividuales 
   TABLE DATA           S   COPY public."ClientesIndividuales" ("CI_Id", "CI_DPI", "CI_ClienteId") FROM stdin;
    public          postgres    false    201   "       �          0    16441    Item 
   TABLE DATA           m   COPY public."Item" ("Item_Id", "Item_Cantidad", "Item_ProductoId", "Item_Total", "Item_IdOrden") FROM stdin;
    public          postgres    false    204    "       �          0    16461    Orden 
   TABLE DATA           �   COPY public."Orden" ("Orden_Id", "Orden_ClienteId", "Orden_Fecha", "Orden_PrecioDeEnvio", "Orden_TipoEnvio", "Orden_Estado", "Orden_DíasEnvio") FROM stdin;
    public          postgres    false    205   ="       �          0    16433 	   Productos 
   TABLE DATA           M   COPY public."Productos" ("Prod_Id", "Prod_Nombre", "Prod_Costo") FROM stdin;
    public          postgres    false    203   Z"       <           2606    16422 0   ClientesEmpresariales ClientesEmpresariales_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public."ClientesEmpresariales"
    ADD CONSTRAINT "ClientesEmpresariales_pkey" PRIMARY KEY ("CE_Id");
 ^   ALTER TABLE ONLY public."ClientesEmpresariales" DROP CONSTRAINT "ClientesEmpresariales_pkey";
       public            postgres    false    202            :           2606    16414 .   ClientesIndividuales ClientesIndividuales_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public."ClientesIndividuales"
    ADD CONSTRAINT "ClientesIndividuales_pkey" PRIMARY KEY ("CI_Id");
 \   ALTER TABLE ONLY public."ClientesIndividuales" DROP CONSTRAINT "ClientesIndividuales_pkey";
       public            postgres    false    201            8           2606    16409    Clientes Clientes_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Clientes"
    ADD CONSTRAINT "Clientes_pkey" PRIMARY KEY ("Cliente_Id");
 D   ALTER TABLE ONLY public."Clientes" DROP CONSTRAINT "Clientes_pkey";
       public            postgres    false    200            @           2606    16445    Item Item_Id 
   CONSTRAINT     U   ALTER TABLE ONLY public."Item"
    ADD CONSTRAINT "Item_Id" PRIMARY KEY ("Item_Id");
 :   ALTER TABLE ONLY public."Item" DROP CONSTRAINT "Item_Id";
       public            postgres    false    204            B           2606    16468    Orden Orden_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Orden"
    ADD CONSTRAINT "Orden_pkey" PRIMARY KEY ("Orden_Id");
 >   ALTER TABLE ONLY public."Orden" DROP CONSTRAINT "Orden_pkey";
       public            postgres    false    205            >           2606    16440    Productos Productos_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public."Productos"
    ADD CONSTRAINT "Productos_pkey" PRIMARY KEY ("Prod_Id");
 F   ALTER TABLE ONLY public."Productos" DROP CONSTRAINT "Productos_pkey";
       public            postgres    false    203            D           2606    16451 *   ClientesEmpresariales FK_ClienteIdEmpresas    FK CONSTRAINT     �   ALTER TABLE ONLY public."ClientesEmpresariales"
    ADD CONSTRAINT "FK_ClienteIdEmpresas" FOREIGN KEY ("CE_ClienteId") REFERENCES public."Clientes"("Cliente_Id") NOT VALID;
 X   ALTER TABLE ONLY public."ClientesEmpresariales" DROP CONSTRAINT "FK_ClienteIdEmpresas";
       public          postgres    false    2872    202    200            C           2606    16456 +   ClientesIndividuales FK_ClienteIdIndividual    FK CONSTRAINT     �   ALTER TABLE ONLY public."ClientesIndividuales"
    ADD CONSTRAINT "FK_ClienteIdIndividual" FOREIGN KEY ("CI_ClienteId") REFERENCES public."Clientes"("Cliente_Id") NOT VALID;
 Y   ALTER TABLE ONLY public."ClientesIndividuales" DROP CONSTRAINT "FK_ClienteIdIndividual";
       public          postgres    false    2872    200    201            F           2606    16469    Item FK_ItemOrdenId    FK CONSTRAINT     �   ALTER TABLE ONLY public."Item"
    ADD CONSTRAINT "FK_ItemOrdenId" FOREIGN KEY ("Item_ProductoId") REFERENCES public."Orden"("Orden_Id") NOT VALID;
 A   ALTER TABLE ONLY public."Item" DROP CONSTRAINT "FK_ItemOrdenId";
       public          postgres    false    205    204    2882            E           2606    16446    Item FK_ProductosIdItem    FK CONSTRAINT     �   ALTER TABLE ONLY public."Item"
    ADD CONSTRAINT "FK_ProductosIdItem" FOREIGN KEY ("Item_ProductoId") REFERENCES public."Productos"("Prod_Id");
 E   ALTER TABLE ONLY public."Item" DROP CONSTRAINT "FK_ProductosIdItem";
       public          postgres    false    203    204    2878            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     