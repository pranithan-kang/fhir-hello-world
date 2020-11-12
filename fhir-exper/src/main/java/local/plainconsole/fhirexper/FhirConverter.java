package local.plainconsole.fhirexper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.BaseResource;

public class FhirConverter {

    private FhirContext ctx;
    private IParser parser;

    public FhirConverter(FhirContext ctx) {
        this.ctx = ctx;
        this.parser = this.ctx.newJsonParser();
    }

    public Patient ConvertToPatient(String jsonString) {

        Patient patient = parser.parseResource(Patient.class, jsonString);
        parser.encodeResourceToString(patient);

        // Test print to see result
        System.out.println(patient.getIdentifier().get(0).getValue());

        return patient;
    }

    public String ConvertToString(BaseResource resource) {

        String encoded = parser.encodeResourceToString(resource);

        // Test print to see result
        System.out.println(encoded);

        return encoded;
    }

}
