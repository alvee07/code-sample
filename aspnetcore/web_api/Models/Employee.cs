using System;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace web_api.Models
{
    public class Employee
    {
        [JsonPropertyName("id")]
        public int EmployeeId { get; set; }

        [JsonPropertyName("employee_name")]
        public string EmployeeName { get; set; }

        [JsonPropertyName("employee_salary")]
        public decimal EmployeeSalary { get; set; }

        [JsonPropertyName("employee_age")]
        public int EmployeeAge { get; set; }

        public Employee()
        {

        }

        public override string ToString()
        {
            return JsonSerializer.Serialize<Employee>(this);
        }
    }
}
