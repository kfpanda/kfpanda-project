CREATE TABLE category(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
NAME VARCHAR(50),
category VARCHAR(100)
);

CREATE TABLE cloth(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
cid BIGINT NOT NULL,
createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
NAME VARCHAR(50),
img VARCHAR(200),
design VARCHAR(30),
composition VARCHAR(50),
width VARCHAR(50),
weight VARCHAR(50),
country VARCHAR(50),
resistance VARCHAR(100),
flammability VARCHAR(100),
shrinkage VARCHAR(30),
washload VARCHAR(50),
colour VARCHAR(100),
environment VARCHAR(100)
);




/** category */
insert into category(name,category) values('Breath ','Breath ');
insert into category(name,category) values('Closer','Closer');
insert into category(name,category) values('Crystal','Crystal');
insert into category(name,category) values('Glint','Glint');
insert into category(name,category) values('Honeycomb','Honeycomb');
insert into category(name,category) values('Linen CS','Linen CS');
insert into category(name,category) values('Mild','Mild');
insert into category(name,category) values('Moonlight','Moonlight');
insert into category(name,category) values('Presence','Presence');
insert into category(name,category) values('Ripple','Ripple');
insert into category(name,category) values('Spring','Spring');



insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Breath 001','breath 001.jpg','Parallel team','100% Trevira CS','300cm','300g/lin.m',' Germany','≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Breath';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Breath 002','breath 002.jpg','Parallel team','100% Trevira CS','300cm','300g/lin.m',' Germany','≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Breath';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Closer 001','closer 001.JPG','Parallel team','100% Trevira CS','330cm','283g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Closer';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Closer 006','closer 006.JPG','Parallel team','100% Trevira CS','330cm','283g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Closer';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Crystal 413','crystal 413.jpg','Parallel team','100% Trevira CS','330cm','330g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Crystal';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Crystal 476','crystal 476.jpg','Parallel team','100% Trevira CS','330cm','330g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Crystal';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Glint 7529','glint 7529.jpg','Parallel team','85% Hemp,15% Polyester','300cm','492g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624 B2','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Glint';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Honeycomb 7531','honeycomb 7531.jpg','Parallel team','60% Polyester,40% Hemp','310cm','364g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624 B2','0.01',' Half','Exact colour matching cannot be guaranteed between batches','310cm' from category where category='Honeycomb';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Linen CS 7500','linen cs 7500.jpg','Parallel team','100% Trevira CS','330cm','358g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Linen CS';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Linen CS 7502','linen cs 7502.jpg','Parallel team','100% Trevira CS','330cm','358g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Linen CS';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Mild 001','mild 001.jpg','Parallel team','100% Trevira CS','310cm','650g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','310cm' from category where category='Mild';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Mild 433','mild 433.jpg','Parallel team','100% Trevira CS','310cm','650g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','310cm' from category where category='Mild';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Mild 7504','mild 7504.jpg','Parallel team','100% Trevira CS','310cm','650g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','310cm' from category where category='Mild';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 463','moonlight 463.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 476','moonlight 476.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 497','moonlight 497.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 728','moonlight 728.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 7528','moonlight 7528.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 7535','moonlight 7535.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Moonlight 5467','moonlight 5467.jpg','Parallel team','100% Polyester FR','300cm','660g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Moonlight';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Presence 001','presence 001.JPG','Parallel team','100% Trevira CS','300cm','253g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Presence';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Presence 002','presence 002.JPG','Parallel team','100% Trevira CS','300cm','253g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','300cm' from category where category='Presence';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Ripple 7501','ripple 7501.JPG','Parallel team','100% Trevira CS','310cm','263g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','310cm' from category where category='Ripple';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Spring 616','spring 616.JPG','Parallel team','100% Trevira CS','330cm','623g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Spring';
insert into cloth(cid,name,img,design,composition,width,weight,country,resistance,flammability,shrinkage,washload,colour,environment) select id,'Spring 693','spring 693.JPG','Parallel team','100% Trevira CS','330cm','623g/lin.m','Italy',' ≥ 6 (1-8  GB/T19817, eqv ISO105)','GB 8624-2012 B1 GB 20286 阻燃1级','0.01',' Half','Exact colour matching cannot be guaranteed between batches','330cm' from category where category='Spring';


UPDATE cloth SET img=CONCAT('/hcloth-imgs/', img); 