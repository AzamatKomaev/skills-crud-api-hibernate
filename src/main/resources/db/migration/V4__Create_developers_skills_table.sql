create table developers_skills (
    developer_id int not null,
    skill_id int not null,

    foreign key (developer_id) references developers(id) on delete cascade,
    foreign key (skill_id) references skills(id) on delete cascade
)