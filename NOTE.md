    PK = Long, auto_increment

#### Pet ( pet )
    PK, PetSituationsPK, name(varchar(100)), age(int), isExpectAge(boolean), gender(char(1)),
    neutered(boolean), openDate(date), closeDate(date), reporter(MemberPK), supporter(MemberPK),
    AnimalClassificationPK
    
    gender : https://stackoverflow.com/questions/4175878/storing-sex-gender-in-database
    
#### Pet Situations ( petsituations )
    PK, situation(varchar(100)) 
    
#### Member ( member )
    PK, name(varhar(100)), phone(varchar(100)), email(varchar(100)), addInfo(json),
    
#### Animal Classification ( classification )
    PK, name(varchar(100))
    
#### Board Kind ( boardkind )
    PK, name(varchar(100))
    
#### Board ( board )
    PK, BoardKindPK, title(varchar(500)), description(varchar(10000))