CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
      # Write your MySQL query statement below.
      declare icount int;
      declare isalary int;
      select count(a.salary) into icount from (select salary from employee group by salary order by salary desc) a;
      if(icount>=n) then
        select c.salary into isalary from (select @rownum:=@rownum+1 as rownum,b.salary from (select @rownum:=0) r,(select salary from employee group by salary order by salary desc) b) c  where c.rownum= n;
     else
     set isalary = null;
     END if;
     RETURN isalary;
END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
      # Write your MySQL query statement below.
     declare isalary int;
     set @rownum=0;
     select c.salary into isalary from (select @rownum:=@rownum+1 as rownum,b.salary from (select salary from employee group by salary order by salary desc) b) c  where c.rownum= n;
     RETURN  isalary;
END